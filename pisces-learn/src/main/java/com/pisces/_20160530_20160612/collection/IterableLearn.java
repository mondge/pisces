package com.pisces._20160530_20160612.collection;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;
import com.pisces._20160530_20160612.dto.Student;
import com.pisces._20160530_20160612.dto.Students;

import java.util.*;

/**
 * Created by jun.xu on 16/5/30.
 */
public class IterableLearn {

    public void test1() {
        Iterable<Integer> concatenated = Iterables.concat(Ints.asList(1, 2, 3), Ints.asList(4, 5, 6));
        Integer lastAdded = Iterables.getLast(concatenated);
        Iterable<Integer> onlyElement = Iterables.concat(Ints.asList(1));
        Integer theElement = Iterables.getOnlyElement(onlyElement);
        System.out.println("lastAdded:" + lastAdded + ",theOnlyElement:" + theElement);
        Iterable<Integer> frequency = Iterables.concat(Ints.asList(1, 2, 3), Ints.asList(2, 3, 4, 5, 3, 4, 5));
        int count = Iterables.frequency(frequency, 3);
        System.out.println("element occurs:" + count);
        Iterable<Student> students = Students.getStudents(10);
        List<String> sexes = Lists.newArrayList("男", "女");
        for (final String sex : sexes) {
            Iterable<Student> stus = FluentIterable.from(students).filter(new Predicate<Student>() {
                @Override
                public boolean apply(Student input) {
                    return input.getSex().equals(sex);
                }
            });
            System.out.println(stus);
        }
    }

    public void test2() {
        Iterable<Student> students = Students.getStudents(10);
        Map<String, Student> studentMap = Maps.uniqueIndex(students.iterator(), new Function<Student, String>() {

            @Override
            public String apply(Student input) {
                return input.getName();
            }
        });
        System.out.println(studentMap);

        ArrayListMultimap<String, String> multiMap = ArrayListMultimap.create();
        multiMap.put("Foo", "1");
        multiMap.put("Foo", "2");
        multiMap.put("Foo", "3");
        multiMap.put("Foo", "3");
        System.out.println(multiMap);

        LinkedHashMultimap<String, String> linkedhashMultiMap = LinkedHashMultimap.create();
        linkedhashMultiMap.put("Foo", "1");
        linkedhashMultiMap.put("Foo", "2");
        linkedhashMultiMap.put("Foo", "3");
        linkedhashMultiMap.put("Foo", "1");
        linkedhashMultiMap.put("Foo", "2");
        linkedhashMultiMap.put("Foo", "3");
        System.out.println(linkedhashMultiMap);

        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("1", "Tom");
        biMap.forcePut("2", "Tom");
        System.out.println(biMap);

        HashBasedTable<Integer, String, String> table = HashBasedTable.create(2, 2);
        table.put(1, "name", "haha");
        table.put(1, "age", "10");
        table.put(2, "name", "gogo");
        table.put(2, "age", "20");
        System.out.println(table.get(1, "name"));
        ;
        System.out.println(table);

        Range<String> range = Range.encloseAll(Lists.newArrayList("女"));
        Function<Student, String> studentFunction = new Function<Student, String>() {
            @Override
            public String apply(Student input) {
                return input.getSex();
            }
        };

        Predicate<Student> predicate = Predicates.compose(range, studentFunction);

        Iterable<Student> result = Iterables.filter(students, predicate);
        List<Student> studentArrayList = Lists.newArrayList(result);
        System.out.println(studentArrayList);
    }

    public void test3() {
        Multiset<String> multiset1 = HashMultiset.create();
        multiset1.add("a", 2);
        Multiset<String> multiset2 = HashMultiset.create();
        multiset2.add("a", 5);
        multiset1.containsAll(multiset2); //返回true；因为包含了所有不重复元素，
        Multisets.containsOccurrences(multiset1, multiset2); // returns false
        multiset2.removeAll(multiset1);//multiset2移除所有"a"，虽然multiset1只有2个"a"
        multiset2.isEmpty(); // returns true
    }

    public void test4() {
        List<Student> result = Lists.newArrayList();
        Iterable<Student> students = Students.getStudents(10);
        PeekingIterator<Student> iterator = Iterators.peekingIterator(students.iterator());
        while (iterator.hasNext()) {
            Student current = iterator.next();
            while (iterator.hasNext() && iterator.peek().getName().equals(current)) {
                iterator.next();
            }
            result.add(current);
        }

        Iterator<Integer> powersOfTwo = new AbstractSequentialIterator<Integer>(1) { // 注意初始值1!
            protected Integer computeNext(Integer previous) {
                return previous + 1;
            }
        };

        for (int i = 0; i < 100; i++)
            System.out.println(powersOfTwo.next());
    }

    public static final ImmutableSet<String> COLOUR_NAMES = ImmutableSet.of("red", "orange");

    public static final ImmutableSet<Student> STUDENTS = ImmutableSet.copyOf(Students.getStudents(10));

    public static final ImmutableSet<Student> STUDENT = ImmutableSet.<Student>builder().addAll(Students.getStudents(10)).addAll(Students.getStudents(5)).build();


    public void test5() {
        Multiset<Student> studentMultiset=HashMultiset.create();
        studentMultiset.addAll(Students.getStudents(10));
        for(Student key:studentMultiset.elementSet()){
            System.out.println(key+" count："+studentMultiset.count(key));
        }
    }

    public void test6(){
        HashMap map=new HashMap(1,1);
        map.put(new Student(1),1);
        map.put(new Student(2), 2);
        map.put(new Student(3), 3);
        map.put(new Student(4), 4);
        map.put(new Student(1),11);
        map.put(new Student(2), 22);
        map.put(new Student(3), 33);
        map.put(new Student(4), 44);
        int number=10;
        int hashCode=new Student(1).hashCode();
//        System.out.println(hashCode);
//        System.out.println(Integer.toBinaryString((number - 1)));
//        System.out.println(Integer.toBinaryString((number - 1) << 1));
//        System.out.println(Integer.highestOneBit((number - 1) << 1));

        Map<Integer,Student> studentMap=new HashMap<>();
        studentMap.put(1,new Student(1));
        studentMap.put(2,new Student(2));
        studentMap.put(3,new Student(3));
        studentMap.put(4,new Student(4));
        studentMap.put(5,new Student(5));
        Set<Map.Entry<Integer, Student>> studentEntrySet=studentMap.entrySet();
        System.out.println(studentEntrySet);
    }
}
