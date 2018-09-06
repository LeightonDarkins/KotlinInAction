package chapterFour

/*
Most verbose class constructor


class User constructor (_nickName: String) {
    val nickName: String

    init {
        nickName = _nickName
    }
}
*/

/*
To stop other code instantiating your class, make the constructor private

class User private constructor(_nickname: String) {}
 */

/*
Slightly less verbose class constructor

class User (_nickName: String) {
    val nickName = _nickName
}
*/

/*
Least verbose constructor

class user(val nickName: String)

with a default param

class user(val nickName: String = "Jimmy")
 */

/*
Default parameter with superclass

open class User(val nickname: String = "Ted")

class TwitterUser(nickname: String) : User(nickname)
 */

/*
If a subclass does not define a constructor, it must call it's parents empty constructor

class RadioButton : Button()
 */

