package com.saffy.day09.gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.events.StartDocument;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherService {
	static List<DailyWeather> slist = new ArrayList<>(); // 내용 저장할 List
	static List<DailyWeather> dlist = new ArrayList<>(); // 내용 저장할 List
	static DailyWeather current; // 임시 저장 객체
	static String content; // 임시 저장 문자열
	static final File xml = new File("weather.xml"); // 저장위치
	
	
	public WeatherService() throws Exception {
		System.out.println("HTTP를 통해  XML형식으로 저장 시작");
		getWeatherInfo("https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4215061500");
		System.out.println("HTTP를 통해 XML형식으로 저장 완료");
		
		
		System.out.println("DOM 방식 출력 시작");
		
		domProcessing();
		
		for(DailyWeather dw : dlist) {
			System.out.println(dw.toString());
		}
	
		
		
		
		System.out.println("SAX 방식 출력 시작");
		saxProcessing();
		for(DailyWeather dw : slist) {
			System.out.println(dw.toString());
		}
		

	}

	private void domProcessing() throws Exception{
		// TODO Auto-generated method stub
		//0단계 팩토리 생성
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//1단계 파서 생성
		DocumentBuilder builder = factory.newDocumentBuilder();
		//문서 저장
		Document doc = builder.parse(xml);
		//최상위 root 저장
		Element root = doc.getDocumentElement();
		
		//root에서 DailyWeather을 추출하여 객체 새로 생성 후list에 저장
		NodeList weathers = root.getElementsByTagName("data");
		//-> <data seq=1> </data>단위로 잘러서 weathers에 저장
		//반복문에서는 한번의 i마다 하나의 data 태그 확인
		for(int i = 0; i < weathers.getLength(); i++) {
			//child에는 <data>~</data>한개가 담겨있음
			Node child = weathers.item(i);
			
			//wea에 <data></data>에서 원하는 태그의 데이터를 객체에 저장
			DailyWeather wea = new DailyWeather();
			
			//<data></data>내에 있는 많은 태그를 각 태그별로 childs에 저장
			NodeList childs = child.getChildNodes();
			
			//for문을 통해 <data></data>내부의 태그 확인하며 필요한 태그만 수집
			for(int j = 0; j < childs.getLength(); j++) {
				Node onetag = childs.item(j);
				if(onetag.getNodeName().equals("hour")) {
					wea.setAfterhour(Integer.parseInt(onetag.getTextContent()));
				}
				else if(onetag.getNodeName().equals("day")) {
					wea.setAfterDay(Integer.parseInt(onetag.getTextContent()));
				}
				else if(onetag.getNodeName().equals("wfKor")) {
					wea.setWeather(onetag.getTextContent());
				}
				else if(onetag.getNodeName().equals("wdKor")) {
					wea.setDir(onetag.getTextContent());
				}
				
			}
			dlist.add(wea);
		}
		
	}

	private void saxProcessing() throws IOException {
		

		// parse
		// TODO Auto-generated method stub
		try {
			// 0단계 팩토리 생성
			SAXParserFactory factory = SAXParserFactory.newInstance();
			// 1단계 파서 생성
			SAXParser parser = factory.newSAXParser();
			// 2단계 핸들러 재정의해서 parse.parse 실행 ㄱㄱ
			parser.parse(xml, new DefaultHandler() {
				@Override // 시작(생성자 같은 느낌)
				public void startDocument() throws SAXException {
					System.out.println("SAX를 사용해 파싱 시작");
				}

				@Override // 종료 (소멸자 같은 느낌)
				public void endDocument() throws SAXException {
					System.out.println("SAX를 사용한 파싱 종료");
				}

				@Override // 태그의 앞부분을 발견하고 characters 호출
				public void startElement(String uri, String localName, String qName, Attributes attributes)
						throws SAXException {
					// TODO Auto-generated method stub
					if (qName.contains("data")) {
						current = new DailyWeather();
					}
				}

				@Override // 태그의 뒷부분을 발견 content에 저장한 내용을 저장한다.
				public void endElement(String uri, String localName, String qName) throws SAXException {
					// TODO Auto-generated method stub
					if (qName.equals("hour"))
						current.setAfterhour(Integer.parseInt(content));
					else if (qName.equals("day"))
						current.setAfterDay(Integer.parseInt(content));
					else if (qName.equals("wfKor"))
						current.setWeather(content.toString());
					else if (qName.equals("wdKor"))
						current.setDir(content.toString());
					else if (qName.contains("data")) {
						slist.add(current);
						current = null;
					}
				}
				//태그의 내용 발견 -> 내용을 content에 저장하고 endElement 호출
				public void characters(char[] ch, int start, int length) throws SAXException {
					content = new String(ch, start, length);
				}

			});
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //
		
	}

	private void getWeatherInfo(String uri) throws Exception {
		URL url = new URL(uri);
		/*
		 * 요청 방식중에 POST 방식을 이용하거나 요청시 헤더 정보를 추가하는 경우등에 사용된다. HttpURLConnection urlConn =
		 * (HttpURLConnection).openConnection(); InputStream in1 =
		 * urlConn.getInputStream();
		 * 
		 */
		InputStream in2 = url.openStream();

		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		StringBuffer xml = new StringBuffer();

		while (true) {
			String line = br.readLine();
			if (line == null)
				break;

			xml.append(line);
		}
		System.out.println(xml);
		createXMLFile(xml);
	}

	private void createXMLFile(StringBuffer xml) throws IOException {
		FileWriter fw = new FileWriter("weather.xml");
		fw.write(xml.toString());
		fw.close();
		System.out.println("저장 OK");
	}
}
