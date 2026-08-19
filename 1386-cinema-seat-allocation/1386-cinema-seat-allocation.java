class Solution { 
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) { 
        long ans = 2 * n; 

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>(); 

        for (int i = 0; i < reservedSeats.length; i++) { 
            int row = reservedSeats[i][0]; 
            int col = reservedSeats[i][1]; 

            if (!map.containsKey(row)) { 
                map.put(row, new HashSet<>()); 
            } 

            map.get(row).add(col); 
        } 

        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) { 
            int key = entry.getKey(); 
            boolean b1 = true; 
            boolean b2 = true; 
            boolean b3 = true; 

            int limit = 0; 

            for (int i = 2; i <= 5; i++) { 
                if (entry.getValue().contains(i)) { 
                    b1 = false; 
                    break; 
                } 
            } 

            for (int i = 6; i <= 9; i++) { 
                if (entry.getValue().contains(i)) { 
                    b3 = false; 
                    break; 
                } 
            } 

            for (int i = 4; i <= 7; i++) { 
                if (entry.getValue().contains(i)) { 
                    b2 = false; 
                    break; 
                } 
            } 

            if (!b1) { 
                limit++; 
            } 

            if (!b3) { 
                limit++; 
            } 

            if (b2) { 
                if (limit == 2) 
                    limit--; 
            } 

            ans -= limit; 
        } 

        return (int)ans; 
    } 
}