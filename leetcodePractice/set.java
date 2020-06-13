// Set注重独一无二，该集合可以知道某物是否已经存在于集合中，不会存储重复的元素
// Set的实现类在面试中常用的是 HashSet and TreeSet


// Hash set
Set<String> set = new HashSet<>();
for (int i = 1; i < 6; i++){
	set.add(i + "");
}
set.add("1"); // 不会重复写入数据
set.add(null); // 可以写入空数据
Iterator<String> iter = set.iterator();
while (iter.hasNext()) {
	system.out.print(iter.next() + ""); //数据无序
}} //输出（无序）：3，4，1，5，null, 2

// TreeSet
Set<String> set = new TreeSet<>();
for (int i = 1; i < 6; i++){
	set.add(i + "");
}
set.add("1"); // 不会重复写入数据
// set.add(null); // 不可以写入空数据
Iterator<String> iter = set.iterator();
while (iter.hasNext()) {
	system.out.print(iter.next() + " "); //数据有序
} // 输出为（有序）： 1，2，3，4，5
