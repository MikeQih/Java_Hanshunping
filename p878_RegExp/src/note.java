public class note {
    
}
/*
正则表达式 (regular expression)：是对字符串执行模式匹配的技术

三个常用类：
1.Pattern
2.Matcher
3.PatternSyntaxException

例子在first.java中

\\d 表示一个任意的数字

matcher.find()完成的任务：
1.根据指定的规则，定位满足规则的字符串 eg.8888
2.找到后，把字符串开始的索引记录到matcher对象的属性 int[] groups;
groups[0]=0，把该子字符串的结束索引+1的值 记录到groups[1]=4
3.同时记录oldLast的值为子字符串的结束的 索引+1的值，即4，下次执行find时，就从4开始匹配

() 表示分组

[] 可接受的字符列表 eg.[efgh] e,f,g,h中的任意一个字符
[^] 不接受的字符列表 eg.[^abc] 除了a,b,c之外的任意一个字符，包括数字和特殊符号
- 连字符 eg.A-Z 任意单个大写字母
. 匹配除\n的任意字符 eg.a..b 以a开头，b结尾，中间包括2个任意字符串的长度为4的字符串 (如果要匹配.本身，\\.)
\\d 匹配单个数字字符 eg.\\d{3} 包含3个数字的字符串 
\\D 匹配单个非数字字符，相当于[^0-9] eg.\\D(\\d)* 单个非数字字符开头，后接任意个 数字字符
\\w 匹配单个数字，大小写和字母和下划线，相当于[0-9a-zA-Z] eg.\\d{3}\\w{4} 3个数字字符开头的长度为7的数字字母字符串
\\W 相当于[^0-9a-zA-Z] eg.\\W+\\d{2} 以至少一个非数字字母字符开头，2个数字字符结尾的字符串(相匹配的输入：#29，#?@10)
\\s 匹配任何空白字符
\\S 除了空白字符，都取
| 选择匹配符
^ 起始字符
$ 结束字符
\\b 匹配边界的目标字符串 (空格间隔和结束位置的目标字符)
\\B 匹配非边界的目标字符串

捕获分组：
(pattern) 分组
(?<name>pattern) 命名捕获

非捕获分组(只能group0，不能用group1,2获取)：(例子在RegExp02中)
(?:pattern)
(?=pattern)
(?!pattern)

非贪婪匹配 \\d+? eg.111111ab 变成非贪婪匹配后，从原来的一次性111111，变成1 1 1 1 1 1


eg. String regStr2 = "(?i)abc"; //匹配abc字符串，不区分大小写；或者：Pattern compile = Pattern.compile(regStr2,Pattern.CASE_INSENSITIVE); 

()* 指定字符0到多次
()+ 1到多次
? 0到1次(最多一次)
{n} 只能有n个字符 eg.[abcd]{3} 由abcd中字母组成的任意长度为3的字符串->abc,dbc,adc
{n,} 至少n个
{n,m} >=n个，<=m个


正则表达式应用实例，看RegExp03.java
在[]中写的 .?* 表示匹配就是它们字符本身

java.util.regex包主要包括以下三个类 Pattern，Matcher，PatternSyntaxException
1.Pattern类：pattern对象是一个正则表达式对象。Pattern类没有公共构造方法，需要创建一个Pattern对象，调用其公共静态方法，返回一个Pattern对象。
该方法接收一个正则表达式作为它的第一个参数。eg.Pattern r = Pattern.compile(pattern);
2.Matcher类：Matcher对象是对输入字符串进行解释和匹配的引擎。也没有公共构造方法，需调用Patttern对象的matcher方法，获得一个Matcher对象
3.PatternSyntaxException：非强制异常类，表示一个正则表达式模式中的语法错误。

用这句验证，加不加^$定位符都无所谓：System.out.println(Pattern.matches(regStr, content));
用传统一点点判断，必须加定位符

看对应类的方法例子：PatternMethod.java...


反向引用：
圆括号的内容被捕获后，可以在这个括号后被使用，从而写出一个比较实用的匹配模式，这个称为反向引用。
这种引用既可以是在正则表达式内部，也可以是在表达式外部，内部反向引用 \\分组号，外部反向引用 $分组号
eg. 匹配连续2个连续的相同数字：(\\d)\\1；匹配5个连续相同数字：(\\d)\\1{4}；匹配个位千位相同，十位百位相同：(\\d)(\\d)\\2\\1
(例子在RegExp04.java中)



看到p902
*/
