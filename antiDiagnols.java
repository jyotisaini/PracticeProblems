/* Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.
*/ 

public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
	     ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(a.isEmpty())
            return result;
            for(int i =0; i<a.size();i ++) {
                for (int j = 0; j < a.get(i).size(); j++) {
                    if(i+j>result.size()-1)
                    {
                        ArrayList<Integer> arrayList = new ArrayList<Integer>();
                        arrayList.add(a.get(i).get(j));
                        result.add(i + j, arrayList);
                    }
                    else
                    {   ArrayList<Integer> list =result.get(i+j);
                        list.add(a.get(i).get(j));

                    }
                }
            }
        return result;
    }
