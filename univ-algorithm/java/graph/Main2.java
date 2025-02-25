public class Main2 {
    public static void main(String[] args) {
        String[] cities = {"서울", "대전", "세종", "공주", "대구", "부산", "경주"};
        WeightedGraph<String> graph = new WeightedGraph<>(cities);

//        graph.addEdge(0,1,7);
//        graph.addEdge(0,2,8);
//        graph.addEdge(0,3,12);
//        graph.addEdge(1,3,5);
//        graph.addEdge(1,4,9);
//        graph.addEdge(1,4,9);
//        graph.addEdge(1,4,9);

        graph.dfs(0);
    }
}
