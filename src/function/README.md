# 함수
```kotlin
fun hello() = "hello"
```
### 기본 정의
코틀린의 함수는 fun 으로 시작한다.  
fun 뒤에 함수의 이름이 오고 함수에서 사용할 파라미터를 명시한다.

단일 표현 함수의 경우에는 컴파일시 리턴 타입을 추론하며 굳이 명시하지 않아도 된다.  
{} 으로 구현된 함수의 경우 리턴 타입을 명시해 주어야 한다.

### Unit
리턴할 것이 아무것도 없을때는 Unit을 사용한다.  
```kotlin
fun returnUnitFunction() {
   print("unit function")
}
```
{}으로 구현된 함수의 경우 리턴 타입을 명시하지 않으면 Unit을 리턴한다.

### 함수의 파라미터
코틀린에서 함수의 파라미터는 반드시 타입을 명시해주어야 한다.
```kotlin
fun functionHasParameter(arg: String) {
}
```
리턴 타입은 생략할 수 있지만 파라미터의 타입은 생략할 수 없다.
또한 파라미터의 값을 바꾸는것도 금지 (컴파일에러 발생) 되어있다.

#### 기본 아규먼트
코틀린에서는 함수에 기본 아규먼트를 할당할 수 있다.
```kotlin
fun functionHasArgument(arg: String = "Hello") {
}
```

#### 명시적 아규먼트
```kotlin
fun functionA(argA: String, argB: String) = "$argA $argB"
``` 
함수 아규먼트이름을 명시해서 호출할 수도 있다. 
이 특성은 가독성을 높여주고 함수 변경을 더 쉽게 할 수 있도록 도와준다.

#### 다중 인자와 스프레드
코틀린에서 많은 수의 인자를 받는 방법은 아래와 같다.
```kotlin
fun max(vararg numbers: Int): Int {
  var maximum = Int.MIN_VALUE
  for(number in numbers) {
    maximum = if(number > maximum) number else maximum
  }
  return maximum
}
```
vararg 키워드를 명시한 함수의 파라미터는 배열 형태로 값을 받는다.
vararg 키워드는 어느 위치에 사용되어도 상관 없지만 마지막에 사용하는게 좋다.
```kotlin
fun multiParameter(msg: String, vararg messages) {
}
multiParameter("A", "B", "C", "D")
```
위와 같이 사용하면 "A"는 msg, ["B", "C", "D"]는 message로 할당이된다.
하지만 vararg를 앞에 사용하면 msg는 꼭 명시적 인자를 사용해야한다.
```kotlin
fun multiParameter(vararg messages:String, msg: String) {
}
multiParameter("A", "B", "C", msg="D")
```

### 구조분해
```kotlin
fun getName() = Triple("Park", "Kim", "Son")
val result = getName()
println("$result.first $result.second $result.third")

val (park, kim, son) = getName()
```
코틀린은 객체의 값을 추출해 변수로 바로 넣는 구조분해 기능이 있다.
위 예제에서 볼 수 있듯이 Triple을 세 개의 변수에 할당할 수 있다.
위치로 구분하여 할당 할 수 있고 사용하지 않을 변수는 _을 이용해서 무시할 수 있다.