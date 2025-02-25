public class Main {
    public static void main(String[] args) {

        String[] names = {"철수", "영희", "동건", "준호", "재상", "승우"};
        Graph<String> graph = new Graph<>(names);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);



        graph.print();
        graph.dfs(5);
        graph.bfs(5);
    }
}
