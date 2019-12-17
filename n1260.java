import java.util.*;
import java.io.*;

public class n1260{
	public static ArrayList<Integer>[] graph;
	public static boolean[] visit;

	public static void dfs(int start){
		if(visit[start]) return;
		visit[start]=true;
		System.out.print(start +" ");
		for(int i=0; i<graph[start].size(); i++){
			int next = graph[start].get(i);
			if(!visit[next]){
				dfs(next);
			}
		}
	}

	public static void bfs(int start){
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visit[start]=true;
		while(queue.size()!=0){
			start = queue.poll();
			System.out.print(start+" ");
			for(int i=0; i<graph[start].size();i++){
				int next = graph[start].get(i);
				if(!visit[next]) {
					queue.offer(graph[start].get(i));
					visit[next]=true;
				}
			}
			
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken())+1;
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n];
		visit = new boolean[n];
		for(int i=0; i < n; i++){
			visit[i] = false;
			graph[i] = new ArrayList<Integer>();
		}
		for(int i=0; i < m; i++){
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			graph[node1].add(node2);
			graph[node2].add(node1);
		}
		for(int i=0; i < n; i++){
			Collections.sort(graph[i]);
		}

		dfs(v);
		for(int i=0; i< n; i++){
			visit[i] = false;
		}
		System.out.print("\n");
		bfs(v);

	}
}