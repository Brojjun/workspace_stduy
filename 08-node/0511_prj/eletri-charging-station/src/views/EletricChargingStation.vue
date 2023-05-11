<template>
    <div>
        <h1>전기차 충전소 현황 정보</h1>

            시도 : 
            <select name="" id="" v-model="zcode">
                <option v-for="obj in zcodes" :key="obj.code" :value="obj.code">
                    {{ obj.desc }}
                </option>
            </select>
            
            구군 : 
            <select name="" id="" v-model="zscode">
                <option v-for="obj in zscodes" :key="obj.code" :value="obj.code">
                    {{ obj.desc }}
                </option>
            </select>
        
            <button @click="searchCharger">검색</button>

            <table>
                <tr>
                    <th>충전소명</th>
                    <th>충전기타입</th>
                    <th>주소</th>
                    <th>시간</th>
                    <th>충전기상태</th>
                    <th>주차료</th>
                </tr>
                <tr v-for="charger,index in chargerList" :key="index">
                    <td>{{charger.statNm}}</td>
                    <td>{{charger.chgerType}}</td>
                    <td>{{charger.addr}}</td>
                    <td>{{charger.useTime}}</td>
                    <td>{{charger.stat}}</td>
                    <td>{{charger.parkingFree}}</td>

                </tr>
            </table>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    name: 'ElectricChargingStation',
    component:{},

    data() {
        return {
            zcode:"",
            zscode:"",
            zcodes:[
                {
                code : 11, desc:"서울특별시",
                },
                {
                code : 26, desc:"부산광역시",
                },
                {
                code : 29, desc:"광주광역시",
                },
                {
                code : 30, desc:"대전광역시",
                },
                {
                code : 47, desc:"경상북도",
                },

            ],
            zscodes:[
                {
                code : 11680, desc:"서울강남구",
                },
                {
                code : 30200, desc:"대전유성구",
                },
                {
                code : 47190, desc:"구미시",
                },
                {
                code : 26440, desc:"부산강서구",
                },
                {
                code : 29200, desc:"광주광역시",
                },

            ],
            chargerList:[],
        }
    },

    mounted() {
        
    },


    methods: {
        searchCharger(){
            const baseUrl = "https://apis.data.go.kr/B552584/EvCharger/getChargerInfo";
            const serviceKey = "5gUs29TyaLJSadj9AIBhr%2FULsKotSQ0elQpaYS7nJjWfPtx51RDPoZvP1u0P9%2BFBzYpymIs3U5O6n9oLHsoNdA%3D%3D";
            const pageNo = 1;
            const numOfRows = 10;

            let url = `${baseUrl}?servicekey=${serviceKey}&pageNo=${pageNo}&numOfRows=${numOfRows}`;
            if(this.zscode) url += `&zscode=${this.zscode}`;
            else url += `&zcode=${this.zcode}`;

            console.log(url);

            axios.get(url).then(response=>{
                this.chargerList = response.data.items[0].item;
                console.log(response.data)
            });
        }
    },
};
</script>

<style lang="scss" scoped>

</style>