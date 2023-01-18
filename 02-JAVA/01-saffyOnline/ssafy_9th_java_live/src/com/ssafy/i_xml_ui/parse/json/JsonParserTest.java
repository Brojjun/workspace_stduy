package com.ssafy.i_xml_ui.parse.json;

import java.util.List;

import com.ssafy.i_xml_ui.parse.BoxOffice;

public class JsonParserTest {
    public static void main(String[] args) {
        UseJson parser = new UseJson();
        List<BoxOffice> list = parser.getBoxOffice();

        for (BoxOffice info : list) {
            System.out.println(info);
        }
    }
}
