#include <stdio.h>
#include <stdlib.h>

enum VisitMode {
    Visited, NotVisited
};

typedef int ElementType;

typedef struct tagVertex { // Vertex = 꼭짓점, 노드
    ElementType Data;
    enum VisitMode Visited;
    int Index;

    struct tagVertex *Next;
    struct tagEdge *AdjacencyList; // 인접 리스트
} Vertex;

typedef struct tagEdge { // Edge = 간선
    int Weight;
    struct tagEdge *Next;
    Vertex *From;
    Vertex *Target;
} Edge;

typedef struct tagGraph {
    Vertex *Vertices;
    int VertexCount;
} Graph;

Graph *CreateGraph();
void DestroyGraph(Graph *G);

Vertex *CreateVertex(ElementType Data);
void AddVertex(Graph *G, Vertex *V);
void DestroyVertex(Vertex *V);

Edge *CreateEdge(Vertex *From, Vertex *Target, int Weight);
void AddEdge(Vertex *V, Edge *E);
void DestroyEdge(Edge *E);

void PrintGraph(Graph *G);