 /*

You are given the following :

A positive number N
Heights : A list of heights of N persons standing in a queue
Infronts : A list of numbers corresponding to each person (P) that gives the number of persons who are taller than P and standing in front of P
You need to return list of actual order of persons’s height

Consider that heights will be unique

Example

Input : 
Heights: 5 3 2 6 1 4
InFronts: 0 1 2 0 3 2
Output : 
actual order is: 5 3 2 1 6 4 
So, you can see that for the person with height 5, there is no one taller than him who is in front of him, and hence Infronts has 0 for him.

For person with height 3, there is 1 person ( Height : 5 ) in front of him who is taller than him.

You can do similar inference for other people in the list.

*/

public ArrayList<Integer> order(ArrayList<Integer> a, ArrayList<Integer> b) {
        if(a==null  || b==null)
            return null;

        ArrayList<Integer> result = new ArrayList<Integer>(a.size());
        ArrayList<Person> personArrayList = new ArrayList<Person>(a.size());

        for (int i = 0; i < a.size(); i++) {
            Person p = new Person();
            p.height = a.get(i);
            p.infronts = b.get(i);
            personArrayList.add(p);
            result.add(-1);
        }
        Collections.sort(personArrayList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                Integer h1 = o1.height;
                Integer h2 = o2.height;
                return h1.compareTo(h2);
            }
        });

        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for( int i =1; i<=a.size(); i++)
            hashMap.put(i, -1);

        for( Person p : personArrayList)
        {
            int count =0;
            for (Map.Entry<Integer, Integer> e : hashMap.entrySet()
                 ) {
                if(e.getValue()==-1)
                    count++;
                if(count==p.infronts+1) {
                    hashMap.put(e.getKey(),p.height);
                    result.set(e.getKey()-1, p.height);
                    break;
                }
            }
        }
        return result;
    }

public class Person

    {
        Integer height;
        Integer infronts;
    }
