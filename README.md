SimSimi API Example Demo Program
===============
##Outline
SimSimi database is composed of a simple set "Question"-"Answer".
If you request "Hi", it responds answer that is more similar than any other answer related questions.
##Description
>1. This is a demo program that is written by various languages for using SimSimi Open API.
  (java, php, javascript, node.js, android)
>2. SimSimi Conversation API supports 45 languages.
>3. You must have a trial-key if you want to test a demo program of example.
If you want to know language code and get Trial-key, Please visit [http://developer.simsimi.com]
>4. Request parameters and Sample request URL

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
