class Solution {
    public String rankTeams(String[] votes) {
        Map<Character,int[]> rank= new HashMap<>();

        for(String vote:votes){
            for(int i=0; i<vote.length(); i++){
                char currMember= vote.charAt(i);
                rank.putIfAbsent(currMember,new int[vote.length()]);
                int [] voteC= rank.get(currMember);
                voteC[i]++;
            }
        }
        PriorityQueue<Map.Entry<Character,int[]>> pq= new PriorityQueue<>((e1,e2)->{
             int[] candidateOneVotes = e1.getValue();
                int[] candidateTwoVotes = e2.getValue();

                int totalVotes = candidateOneVotes.length;
                  for (int i = 0; i < totalVotes; i++) {
                    if (candidateOneVotes[i] != candidateTwoVotes[i]) {
                        return Integer.compare(
                            candidateTwoVotes[i],
                            candidateOneVotes[i]
                        );
                    }
                }

                
                return Character.compare(e1.getKey(), e2.getKey());

        });
         for (Map.Entry<Character, int[]> e :
                rank.entrySet()) {
            pq.add(e);
        }

        StringBuilder ans = new StringBuilder();

        while (!pq.isEmpty()) {
            ans.append(pq.poll().getKey());
        }

        return ans.toString();
    }
}