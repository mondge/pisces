package com.pisces.ds.graph;

import com.pisces.ds.graph.dto.Edge;
import com.pisces.ds.graph.dto.Vertex;

import java.util.Iterator;

/**
 * Created by jun.xu on 16/5/11.
 */
public interface Graph {
    public static final int UNDIRECTEDGRAPH = 0;//无向图

    public static final int DIRECTEDGRAPH = 1;//有向图

    public int getType();

    public int getVexNum();

    public int getEdgeNum();

    public Iterator getVertex();

    public Iterator getEdge();

    public void remove(Vertex vertex);

    public void remove(Edge edge);

    public void insert(Vertex vertex);

    public void insert(Edge edge);

    public boolean areAdjacent(Vertex u, Vertex v);

    public Edge edgeFromTo(Vertex from, Vertex to);

    public Vertex adjVertexs(Vertex u);

    public Iterator DFSTraverse(Vertex v);

    public Iterator BFSTraverse(Vertex v);

    public Iterator shortestPath(Vertex v);

    public void generateMST() throws UnsupportedOperationException;//有向图不支持此操作

    public Iterator toplogicalSort() throws UnsupportedOperationException;//无向图不支持此操作

    public void criticalPath() throws UnsupportedOperationException;//无向图不支持此操作


}
