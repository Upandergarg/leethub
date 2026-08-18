class Solution {
    public String rankTeams(String[] votes) {

        Map<Character, int[]> rankByEachCharacterMap = new HashMap<>();

        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                char currMember = vote.charAt(i);

                rankByEachCharacterMap.putIfAbsent(
                    currMember,
                    new int[vote.length()]
                );

                int[] voteCount = rankByEachCharacterMap.get(currMember);
                voteCount[i]++;
            }
        }

        // Keys - sort, Max heap - PQ, TreeMap - SortOrder
        PriorityQueue<Map.Entry<Character, int[]>> pq =
            new PriorityQueue<>((e1, e2) -> {

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
                rankByEachCharacterMap.entrySet()) {
            pq.add(e);
        }

        StringBuilder ans = new StringBuilder();

        while (!pq.isEmpty()) {
            ans.append(pq.poll().getKey());
        }

        return ans.toString();
    }
}