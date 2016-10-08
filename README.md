# searchkorean
한글 초성 검색 으로 유효성 검사 및 Mini 검색 도구

안드로이드서 사용하든, java에서 사용하든 한글 초성으로 검색을 위해 일단 유효성 검사 필터를 예전에 만듬

연산은 조금 복잡하지만 구조는 상당히 간단히 되어있음.

지속적으로 업데이트 할 예정

*Gradle은 안드로이드 버전 전용임. 다른곳에서 쓰려면 코드에서 클래스하나 복사 하면됨.


#Gradle
<pre>
repositories {
    maven { url "https://jitpack.io" }
}

</pre>

<pre>
dependencies {
    compile 'com.github.roka88:searchkorean:0.0.1'
}
</pre>

#Hot to Use?
Example에 나와있음

#Example
<pre><xmp>
public class Main {

    public static void main(String[] args) {
	    RokaSearchKorean rokaSearchKorean = new RokaSearchKorean();

        System.out.println("유효성 검사 text : "+"ㄱㄴ"+ " / 체크 text : "+"강남"+" / 결과 : "+rokaSearchKorean.speedHangleCheck("ㄱㄴ", "강남"));
        System.out.println("유효성 검사 text : "+"ㄱㄴ서울"+ " / 체크 text : "+"강남서울"+" / 결과 : "+rokaSearchKorean.speedHangleCheck("ㄱㄴ서울", "강남서울"));
        System.out.println("유효성 검사 text : "+"ㅂㅅㄷ"+ " / 체크 text : "+"부산대"+" / 결과 : "+rokaSearchKorean.speedHangleCheck("ㅂㅅㄷ", "부산대"));
        System.out.println("유효성 검사 text : "+"ㅂㅅㄷ"+ " / 체크 text : "+"부산대 학교"+" / 결과 : "+rokaSearchKorean.speedHangleCheck("ㅂㅅㄷ", "부산대 학교"));
        System.out.println("유효성 검사 text : "+"ㅂㅅㄷ 학교"+ " / 체크 text : "+"부산대 학교"+" / 결과 : "+rokaSearchKorean.speedHangleCheck("ㅂㅅㄷ 학교", "부산대 학교"));
        System.out.println("유효성 검사 text : "+"ㅇㅃ ㄱㄴㅅㅌㅇ"+ " / 체크 text : "+"오빤 강남스타일"+" / 결과 : "+rokaSearchKorean.speedHangleCheck("ㅇㅃ ㄱㄴㅅㅌㅇ", "오빤 강남스타일"));
        System.out.println("유효성 검사 text : "+"ㅅㅅ 레이데"+ " / 체크 text : "+"섹시 레이데 웁웁"+" / 결과 : "+rokaSearchKorean.speedHangleCheck("ㅅㅅ 레이데", "섹시 레이데 웁웁"));
        System.out.println("유효성 검사 text : "+"ㅇㅃ "+ " / 체크 text : "+"오빤 강남스타일 ~_~"+" / 결과 : "+rokaSearchKorean.speedHangleCheck("ㅇㅃ", "오빤 강남스타일 ~_~"));
        System.out.println("유효성 검사 text : "+"라라라"+ " / 체크 text : "+"이수영의 라라라 ~_~"+" / 결과 : "+rokaSearchKorean.speedHangleCheck("라라라", "이수영의 라라라 ~_~"));


        ArrayList<String> list = new ArrayList<>();
        list.add("강남");
        list.add("나는야 Roka");
        list.add("한국 종합 센터");
        list.add("나레이터");
        list.add("달구지 먹자~");
        list.add("랑데뷰");
        list.add("마늘 먹기 싫어");
        list.add("바본가봐 그대는");
        list.add("사랑해 너무 사랑해");
        list.add("오늘 너무 피곤해");
        list.add("자고 싶다");
        list.add("차차차차~");
        list.add("ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
        list.add("푸른 언덕에~배낭을 메고~");
        list.add("하얀 구름 저 푸른 바다");
        list.add("쎼쎼쎼~ 아침바람 찬 바람에");
        list.add("뜨거~ 핫 뜨거뜨거 핫뜨거핫");
        list.add("짜라짜라 짜짜짜~ 무조건 무조건이야~");
        list.add("뽀로로를 아시나요");
        list.add("끄억~ 맛좋다");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("찾을 문자를 작성해주세요. : ");
            String tempText = scanner.nextLine();

            for (String str : list) {
                if (rokaSearchKorean.speedHangleCheck(tempText, str)) {
                    System.out.println(str+"\n");
                }

            }
        }
    }
}
</xmp></pre>


#Result
<pre><xmp>
유효성 검사 text : ㄱㄴ / 체크 text : 강남 / 결과 : true
유효성 검사 text : ㄱㄴ서울 / 체크 text : 강남서울 / 결과 : true
유효성 검사 text : ㅂㅅㄷ / 체크 text : 부산대 / 결과 : true
유효성 검사 text : ㅂㅅㄷ / 체크 text : 부산대 학교 / 결과 : true
유효성 검사 text : ㅂㅅㄷ 학교 / 체크 text : 부산대 학교 / 결과 : true
유효성 검사 text : ㅇㅃ ㄱㄴㅅㅌㅇ / 체크 text : 오빤 강남스타일 / 결과 : true
유효성 검사 text : ㅅㅅ 레이데 / 체크 text : 섹시 레이데 웁웁 / 결과 : true
유효성 검사 text : ㅇㅃ  / 체크 text : 오빤 강남스타일 ~_~ / 결과 : true
유효성 검사 text : 라라라 / 체크 text : 이수영의 라라라 ~_~ / 결과 : true
찾을 문자를 작성해주세요. : ㅆㅆ
쎼쎼쎼~ 아침바람 찬 바람에

찾을 문자를 작성해주세요. : ㄲ
끄억~ 맛좋다

찾을 문자를 작성해주세요. : ㅉ
짜라짜라 짜짜짜~ 무조건 무조건이야~

찾을 문자를 작성해주세요. : ㅃ
뽀로로를 아시나요

찾을 문자를 작성해주세요. : ㅋㅋㅋㅋ
ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ

찾을 문자를 작성해주세요. : ㄸ
뜨거~ 핫 뜨거뜨거 핫뜨거핫

찾을 문자를 작성해주세요. : 아침
쎼쎼쎼~ 아침바람 찬 바람에
</xmp></pre>

#License

<pre>
Copyright 2016 Roka

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
</pre>
