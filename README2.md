심심이 대화 API 예제 프로그램
===============
##개요
심심이 데이터베이스는 간단한 "질문"-"대답" 세트로 구성되어 있습니다.
"안녕"이라는 요청이 들어오면, 질문과 가장 유사도가 높은 "질문"-"대답"의 세트의 "대답"이 응답으로 나가게 됩니다.
##설명
>1. 심심이 대화 API 서비스를 더 쉽게 사용하기 위해서 다양한 언어로 만들어진 예제입니다.
  (java, php, javascript, node.js, android)
>2. 심심이 대화 API는 45개국어를 지원합니다.
>3. 당신은 이 예제 프로그램을 실행시키려면 반드시 trial-key가 있어야 합니다.
만약 당신이 45개국어를 지원하는 언어코드와 trial-key를 알고싶다면 [http://developer.simsimi.com] 를 접속해주시기 바랍니다.
>4. 당신이 SimSimiAPIDemoExample에 있는 예제 프로그램들을 실행시킨다면 사용자의 text와 lc 값을 입력받습니다.  
>5. Request parameters and Sample request URL

|Parameter |Value            |Required |Default |Description      |
|:---------|:-------------   |:--------|:-------|:-----------     |
|key       |String           |Y        |        |Your key value   |
|text      |String           |Y        |        |Query message    |
|lc        |String           |Y        |        |Language code    |
|ft        |Double(0.0~1.0)  |         |0.0     |                 |

|Key Type        |Sample request URL                                                                    |
|:-------------- |:----------------------------------------------------------------------------------   |
|Trial-key       |http://sandbox.api.simsimi.com/request.p?key=your_trial_key&lc=en&ft=1.0&text=hi      |
|Paid-key        |http://api.simsimi.com/request.p?key=your_paid_key&lc=en&ft=1.0&text=hi               |
