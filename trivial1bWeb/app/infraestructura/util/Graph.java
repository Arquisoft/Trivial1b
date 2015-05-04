package infraestructura.util;

import java.text.DecimalFormat;

public class Graph <T>{
	
	T[] nodes;
	boolean [][]edges;
	double [][] weights;
	int numNodes; //numero de nodos en un momento determinado
	int tamanoMaximo;
	

//	public Graph(int tama�oMaximo){
//		nodes = new Object[tama�oMaximo];
//		edges = new boolean[tama�oMaximo][tama�oMaximo];
//		weight = new double[tama�oMaximo][tama�oMaximo];
//		numNodes=0;
//	}
	
	/**
	 * Constructor con parametros de la clase Graph
	 * @param tama�oMaximo n�mero maximo de nodos que puede contener el grafo
	 * Se inicializa el vector de nodos y la matriz de edges y weight con el tama�oMaximo
	 *  El numero de nodos inicial es de cero, ya que aun no se ha a�adido ninguno
	 */
	@SuppressWarnings("unchecked")
	public Graph(int tamanoMaximo) {
		//nodos = new T[tam];   // No se puede crear un array de gen�ricos
		nodes = (T[])new Object[tamanoMaximo];  //En Java hay que hacerlo as�
		edges = new boolean[tamanoMaximo][tamanoMaximo];
		weights = new double[tamanoMaximo][tamanoMaximo];
		numNodes = 0;
		this.tamanoMaximo = tamanoMaximo;
	}
	
	/* Por ejemplo se crear�an as�: 
	 * 		Graph<Integer> g=new Graph<Integer>(100);
	 * 		Graph<String> g=new Graph<String>(100);
	 * 		Graph<Character> g=new Graph<Character>(100);
	 * 		Graph<MiClaseNodo> g=new Graph<MiClaseNodo>(100);
	 */
	
		/**
		 * M�todo para comprobar cuantos nodos hay en un grafo
		 * @return numNodes, numero de nodos del grafo
		 */
		public int getNumNodes() {
			return numNodes;
		}

		/**
		 * M�todo que para comprobar el buen funcionamiento del vector de nodos
		 * @return nodes, vector de nodos
		 */
		public T[] getNodes() {
			return nodes;
		}

		/**
		 * M�todo que para comprobar el buen funcionamiento de la matriz de aristas
		 * @return edges, matriz de aristas (si existe o no conexion entre los nodos de un grafo, T si existe, F no existe)
		 */
		public boolean[][] getEdges() {
			return edges;
		}

		/**
		 * M�todo que para comprobar el buen funcionamiento de la matriz de pesos
		 * @return weight, matriz de pesos (valor que toma una arista cuando conecta dos nodos, 0 si no hay conexi�n, >0 cuando si existe)
		 */
		public double[][] getWeights() {
			return weights;
		}

		/**
		 * Devuelve una cadena con la informaci�nn del grafo
		 */
		public String toStringAssert() {
			String cadena = "";
			T[] nodos = getNodes();
			boolean[][] aristas = getEdges();
			double[][] pesos = getWeights();
			int numNodos = getNumNodes();
			
			cadena += "VECTOR NODOS\n{";
			for (int i = 0; i < nodos.length; i++) {
				if (nodos[i]==null || i>=numNodos)
					cadena+="null";
				else
					cadena += nodos[i].toString();
				if (i<nodos.length-1) 
					cadena+= ", ";
			}
			cadena+="}";
			cadena += "\n\nMATRIZ ARISTAS\n";
			cadena+="{"; 
			for	(int i=0; i<aristas.length; i++) {
				cadena+="{";
				for (int j=0; j<aristas.length; j++) { 
					if (i<numNodes && j<numNodes)
						cadena += aristas[i][j]?"T":"F";
					else
						cadena+="F";
					if (j<aristas.length-1)
						cadena+=", "; 
				} 
				cadena += "}";
				if (i<aristas.length-1)
					cadena+=",\n ";
			} 
			cadena+="}";

			
			cadena += "\n\nMATRIZ PESOS\n";
			DecimalFormat df = new DecimalFormat(" #.## ");
			cadena+="{"; 
			for	(int i=0; i<pesos.length; i++) {
				cadena+="{";
				for (int j=0; j<nodes.length; j++) { 
					if (i<numNodes&&j<numNodes)
						cadena += 	df.format(pesos[i][j]);
					else
						cadena+=df.format(0);
					if (j<pesos.length-1)
						cadena+=","; 
				} 
				cadena += "}";
				if (i<pesos.length-1)
					cadena+=",\n ";
			} 
			cadena+="}\n";
			System.out.print(cadena);
			return cadena;
	}  
		
	/**
	 * M�todo para a�adir nodos al grafo
	 * @param node nombre del nodo
	 * @return 0 si se ha podido completar la acci�n y -1  si no se ha podido completar la acci�n
	 */
	public int addNode(T node){ 		
		if(!existNode(node) && numNodes<nodes.length)//existe ya el nodo y hay hueco?
			{
			nodes[numNodes] = node; //lo a�ado a la lista de nodos
				for(int i=0; i<=numNodes;i++){		
					edges[numNodes][i]=false;	//lo a�ado a la lista de ejes
					edges[i][numNodes]=false;
					weights[numNodes][i]=0;		//lo a�ado a la lista de pesos
					weights[i][numNodes]=0;
				}
				numNodes++;	
				return 0;
			}
		else
			return -1;
	}
	
	/**
	 * M�todo para a�adir eges a los nodos insertados
	 * @param source nodo del que parte
	 * @param target nodo al que llega
	 * @param w peso que queremos que tenga el nodo
	 * @return 0 si se ha podido completar la acci�n y -1  si no se ha podido completar la acci�n
	 */
	public int addEdge(T source, T target, double w){
		if((existNode(source))&&(existNode(target))&&(w>0)){
			edges[getNode(source)][getNode(target)]=true;
			weights[getNode(source)][getNode(target)]=w;
			return 0;
			}
		else
			return -1;
	}
	
	/**
	 * M�todo para comprobar si existe o no un nodo
	 * @param node nombre del nodo que queremos comprobar
	 * @return true si el nodo existe y false si el nodo no existe
	 */
	public boolean existNode(T node){
			if(getNode(node)>=0)
				return true;
			else
				return false;
	}
	
	/**
	 * M�todo para comprobar si existe o no una arista
	 * @param source nodo del que parte
	 * @param target nodo al que llega
	 * @return true si existen los dos nodos y hay un camino entre ellos (el peso de la arista es mayor de cero) y false si no existe
	 */
	public boolean existsEdge(T source, T target){
		if((getNode(source)!=-1)&&(getNode(target)!=-1)&&(weights[getNode(source)][getNode(target)]>0)){
			return true;
		}
			
		return false;
	}
	
	/**
	 * M�todo para comprobar en que posicion se encuentra un nodo
	 * @param node nombre del nodo que queremos comprobar
	 * @return i la posicion en la que se encuentra el nodo y -1 si el nodo no existe
	 */
	private int getNode(T node){
		for (int i=0; i<numNodes; i++)
			if (nodes[i].equals(node))
				return i;	
			return (-1); //el nodo no existe
		}
	
	/**
	 * M�todo para comprobar si un edge tiene peso
	 * @param source nodo del que parte
	 * @param target nodo al que llega
	 * @return el peso del edge si este existe y -1 si el peso no existen uno o dos de los nodos requeridos
	 */
	public double getEdge(T source, T target){
		if((getNode(source)!=-1)&&(getNode(target)!=-1)&&((weights[getNode(source)][getNode(target)])!=0)){
			return weights[getNode(source)][getNode(target)];
		}
		else
			return -1;
	}
	
	/**
	 * M�todo para borrar un nodo del grafo
	 * @param node nombre del nodo que queremos borrar
	 * @return 0 si se ha podido completar la acci�n y -1  si no se ha podido completar la acci�n
	 */
	public int removeNode(T node){
		int n = getNode(node);
		
		if(existNode(node)){
			--numNodes;
			if(n!=numNodes+1)
				nodes[n]=nodes[numNodes];
			for(int i=0;i<numNodes;i++){
				edges[i][n]=edges[i][numNodes];
				edges[n][i]=edges[numNodes][i];
				weights[i][n]=weights[i][numNodes];
				weights[n][i]=weights[numNodes][i];
				
				edges[i][numNodes]=false;
				edges[numNodes][i]=false;
				weights[i][numNodes]=0;
				weights[numNodes][i]=0;
				}
				edges[n][n]=edges[numNodes][numNodes];
				weights[n][n]=weights[numNodes][numNodes];
		return 0;
		}
		return -1;
	}
	
	/**
	 * M�todo para borrar un peso 
	 * @param source nodo del que parte
	 * @param target nodo al que llega
	 * @return 0 si se ha podido completar la acci�n y -1  si no se ha podido completar la acci�n
	 */
	public int removeEdge(T source, T target){
		if((existNode(source))&&(existNode(target))&&((weights[getNode(source)][getNode(target)])!=0)){
			edges[getNode(source)][getNode(target)]=false;
			weights[getNode(source)][getNode(target)]=0.0;
			return 0;
		}
		else
			return -1;
	}
	
	/**
	 * M�todo para tratar los nodos dentro del m�todo recorridoProfundidad
	 * @param nodo nodo que queremos tratar, en este caso imprimir por pantalla
	 */
	private void tratarNodo(int nodo){
		System.out.print(nodes[nodo].toString()+"\t"); //toString para aclarar
	}
	
	/**
	 * M�todo para hayar el recorrido en profundidad desde un nodo
	 * Este m�todo requiere una matriz V[] de booleanos en la que se encuentran a
	 * true los nodos que ya han sido visitados (tratados)
	 * false los nodos que aun quedan por visitar
	 * El m�todo comprueba a que nodos de un grafo se puede llegar desde un nodo origen
	 * @param node nodo desde el que queremos hayar el recorrido en profundidad
	 * @return 0 si se han podido visitar todos los nodos del grafo y -1 si no se han podido visitar todos los nodos del grafo
	 */
	public int recorridoProfundidad(T node){
		//recorre todos los nodos = 0
		//no los recorre = -1
		boolean[] v = new boolean[numNodes];
		for(int i = 0; i<numNodes; i++)
		{
			v[i]=false;
		}
		if(existNode(node)){
			int a = getNode(node);
			recProf(a, v);//el nodo tiene un hijo directo
			for(int i =0; i<numNodes; i++){
				if(v[i]==false){
//					System.out.println();
					return -1;
				}
			}
//			System.out.println();
			return 0;}
		return -1;
	}
	
	/**
	 * M�todo que comprueba si un nodo ha sido o no tratado
	 * Si ha sido tratado no hace nada
	 * Si no ha sido tratado lo trata y comprueba si se pueden ir a mas nodos a partir de el
	 * @param nodo nodo que queremos ver si podemos tratar
	 * @param v vector V[] de booleans que indica que nodos han sido tratados
	 */
	private void recProf(int nodo, boolean[] v){ //va a ser recursivo
			if(!v[nodo]){ //el nodo no ha sido tratado
				tratarNodo(nodo);
				v[nodo]=true;
				for(int i = 0; i<numNodes; i++){
					if(edges[nodo][i]==true)
						recProf(i, v);
				}
			}
			else;
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//dijkstra(T nodo) -> nodo el nodo origen (donde estoy)
	//T nodo final (pulsa) -> i
	//si retorno dijkstra [i] = dado => me puedo mover (los pasos que doy para llegar)
	
	/**
	 * M�todo que comprueba el camino de menos peso a todos los nodos del grafo desde un nodo origen
	 * @param nodo, nodo desde el que queremos partir
	 * @return D, vector D[] de doubles que recoge los pesos minimos para llegar a un nodo desde el origen
	 */
	public double [] dijkstra(T nodo){
		boolean[] V = new boolean [numNodes]; //los que ya he visitado
		double[] D = new double[numNodes]; 	// pesos Double.MAX_VALUE los que no tiene acceso directo
		int [] P = new int [numNodes]; //path
		
		//inicializamos los vectores
		
		int a = getNode(nodo);
		
		for(int k=0; k<numNodes; k++){
			if(getEdge(nodo, nodes[k])!=-1){
				D[k]= weights[a][k];
				P[k]= a;
			}
			else{
				D[k]=Double.MAX_VALUE;
				P[k]=-1;
			}
		}
		
		V[a]=true;
		D[a]=0;
		
		boolean comp = comprobarTrues(V);
		while(comp==false){
			int siguiente = minCoste(D, V);

				for(int i=0; i<numNodes;i++){
						if((D[i]>(D[siguiente]+weights[siguiente][i]))&&(getEdge(nodes[siguiente], nodes[i])!=-1)){
							D[i]= D[siguiente]+weights[siguiente][i];
							P[i] = siguiente;
					}
				}
				V[siguiente]=true;
				comp = comprobarTrues(V);
			}

		return D;
	}
	
	/**
	 * M�todo que haya el nodo con coste minimo de un grafo desde el cual se sigue haciendo dijkstra
	 * @param d vector D[] de pesos 
	 * @param v vector V[] de booleans, los nodos que ya han sido visitados
	 * @return min, el nodo con coste minimo al que se puede acceder 
	 */
	private int minCoste(double[] d, boolean[]v){
		//dist  el vector D
		//v el vector V
		//a donde puede ir el vector con el menor coste
		//V > false = el nodo aun no ha sido visitado
		int min = -1;
		double valor = Double.MAX_VALUE;
		
		for(int i=0; i<numNodes; i++){
			if((d[i]<=valor) && (v[i]!=true)){
				min = i;
				valor=d[i];
			}
		}
		return min;
		}
	
	/**
	 * 
	 * @param v vector V[] de booleanos despues de haber aplicado dijkstra
	 * @return true si todos los nodos han sido visitados y false si algun nodo ha quedado sin visitar
	 */
	private boolean comprobarTrues(boolean[]v){
		boolean ret = true;
		for(int i=0; i<numNodes; i++){
			if(v[i]==false)
				ret = false;
		}
		return ret;
	}
	
	
//	public int comparaVectores(double[]dij, double[]mio){
//		for(int i=0; i<numNodes; i++){
//			if(dij[i]!=mio[i])
//				return -1;
//	}
//		return 0;
//	}
	
	/**
	 * M�todo que haya el camino de coste minimo de todos los nodos del grafo
	 * Matriz P
	 * 		-1 cuando no existe camino
	 * 		i el nodo por el cual es mas rapido ir
	 * Matriz A
	 * 		0 en la diagonal
	 * 		i peso minimo para ir de un nodo a otro
	 * 		Double.MAX_VALUE si no hay forma de llegar a ese nodo
	 * @return P, matriz P[][] de pasos, 
	 */
	public int [][] floyd(){
//		/**
//		 * Matriz inicial
//		 * Donde no hay arista infinito
//		 * Donde si hay, el peso
//		 * En la diagonal 0 en la matriz de pesos
//		 * en la diagonal -1 en la matriz de pasos
//		 * Cuidado con las comparacion con el infinito!
//		 * 
//		 * Para todo camio entre dos nodos se mira si mejora con un nodo intermedio.
//		 * tres for anidado, calcular para todos los nodos del grafo
//		 * 
//		 * A --- 1 ---- B    A	B	C	D
//		 * |			|	 -1	A	B	C
//		 * |			|		-1	B	C
//		 * 10           2				C
//		 * |			|
//		 * |			|
//		 * D --- 3 --- C
//		 * 
//		 * Matriz [][]A la de pesos
//		 * Matriz [][]P la de pasos
//
//		for(int k=0; k<numNodes; k++){
//		if(getEdge(nodo, nodes[k])!=-1){
//			D[k]= getEdge(nodo, nodes[k]);
//			P[k]= a;
//		}
//		else{
//			D[k]=Double.MAX_VALUE;
//			P[k]=-1;
//		}
//		 */
		
		double [][] A = new double [numNodes][numNodes];	// matriz de Pesos
		int [][] P = new int [numNodes][numNodes];	// matriz de Pasos

		for(int i = 0; i < numNodes; i++){
			for(int j = 0; j < numNodes; j++){
				if(i==j){
					A[i][j]=0;
					P[i][j]=-1;
				}
				else{
					if(getEdge(nodes[i], nodes[j])!=-1){
						A[i][j]= weights[i][j];
						P[i][j]= -1;
					}
					else{
						A[i][j]= Double.MAX_VALUE;
						P[i][j]= -1;
					}
				}
			}
		}
		for (int k=0; k<numNodes; k++)
			for (int i=0; i<numNodes; i++)
				for (int j=0; j<numNodes; j++)
					if ((A[i][k] + A[k][j] < A[i][j])&&(A[i][k]!=Double.MAX_VALUE)&&(A[k][j]!=Double.MAX_VALUE))
					{
					A[i][j] = A[i][k] + A[k][j];
					P[i][j] = k;
					}
//		System.out.print("\n");
		return P;
	}
	
		/**
		 * M�todo que comprueba cual es el coste minimo para ir de un grafo a otro utilizando unicamente
		 * la matriz de pasos P[][] que devuelve el metodo floyd()
		 * @param o nodo origen
		 * @param d nodo destino
		 * @return result, coste minimo para ir de un nodo a otro
		 */
		public double path(T o, T d){
//		/**
//		 * tratar el nodo
//		 * camino distinto que printPath
//		 * Aparte de recorrer el nodo desde el origen al destino
//		 * va a devolver un double que sera el resultado de acumular todos los pesos
//		 * de las aristas recogidas.
//		 * No hay que usar la matriz A, hay que utilizar la matriz P
//		 * que me indica el resultado de floyd(); recorrerlo y acumularlo
//		 * Utilizarlo recursivo!!
//		 * aunque este se pueda hacer recursivo, mejor hacer un metodo recursivo
//		 * en el que se haga todo
//		 */
			int [][] f = floyd();
			int O = getNode(o);
			int D = getNode(d);
		
			double result =0;
			if(O!=-1&&D!=-1){
				tratarNodo(O);
				result = pathRec(O, D, f);
				
				System.out.print("( " + result + " )" + "\n");				
			}
			
			return result;
	}
		
		/**
		 * M�todo recursivo que calcula cual es el camino minimo desde un nodo a otro
		 * Caso base: si en la matriz de pasos el nodo origen coincide con el nodo por el que debe pasar para llegar al destino
		 * se finaliza el m�todo recursivo, retornando el valor de la suma total
		 * Si, por el contrario, existe un nodo intermedio por el cual se pueda pasar para llegar al nodo destino
		 * se vuelve a repetir el metodo recursivo hasta llegar al caso base
		 * @param o posicion de la que partes
		 * @param d posicion al que quieres llegar
		 * @param pFloyd matriz de caminos minimos calculada anteriormente por Floyd()
		 * @return el resultado de acumular todos los pesos de las aristas recorridas
		 */
		private double pathRec(int o, int d, int [][]pFloyd){
//			if(o==d){
//				tratarNodo(o);
////				System.out.print(nodes[o]);
//				return weights[o][d];
//				}
//			if(pFloyd[o][d]!=-1){
//					tratarNodo(o);
////					System.out.print(nodes[d] + " ");
////					System.out.print(nodes[d] + " < " + weights[pFloyd[o][d]][d] + " < ");
//					return weights[o][d] + pathRec(pFloyd[o][d], d , pFloyd);
//			}
//			else{
//				tratarNodo(o);
//				tratarNodo(d);
//				//				System.out.print(nodes[d] + " < " + weights[o][d] + 
////						" < " + nodes[o] + " ");
//				return weights[o][d];
//			}
			
			double peso = 0;
			
			if(o==d){
				peso = 0;
			
			}
		    else if ((pFloyd[o][d]==-1)){
		    	if(edges[o][d]){
		    	tratarNodo(d);
				peso = weights[o][d];
		    	}
		    	
		    }
		      else{
		    	
		    	 peso = weights[o][d] + pathRec(o,pFloyd[o][d], pFloyd) + pathRec(pFloyd[o][d], d, pFloyd);
		    }
		return peso;
		}
		
		
	
		public double [][] floydExcentricidad(){
			/**
			 * Matriz inicial
			 * Donde no hay arista infinito
			 * Donde si hay, el peso
			 * En la diagonal 0 en la matriz de pesos
			 * en la diagonal -1 en la matriz de pasos
			 * Cuidado con las comparacion con el infinito!
			 * 
			 * Para todo camio entre dos nodos se mira si mejora con un nodo intermedio.
			 * tres for anidado, calcular para todos los nodos del grafo
			 * 
			 * A --- 1 ---- B    A	B	C	D
			 * |			|	 -1	A	B	C
			 * |			|		-1	B	C
			 * 10           2				C
			 * |			|
			 * |			|
			 * D --- 3 --- C
			 * 
			 * Matriz [][]A la de pesos
			 * Matriz [][]P la de pasos
	
			for(int k=0; k<numNodes; k++){
			if(getEdge(nodo, nodes[k])!=-1){
				D[k]= getEdge(nodo, nodes[k]);
				P[k]= a;
			}
			else{
				D[k]=Double.MAX_VALUE;
				P[k]=-1;
			}
			 */
			
			double [][] A = new double [numNodes][numNodes];	// matriz de Pesos
			int [][] P = new int [numNodes][numNodes];	// matriz de Pasos

			for(int l = 0; l < numNodes; l++){
				for(int j = 0; j < numNodes; j++){
					if(l==j){
						A[l][j]=0;
						P[l][j]=-1;
					}
					else{
						if(getEdge(nodes[l], nodes[j])!=-1){
							A[l][j]= getEdge(nodes[l], nodes[j]);
							P[l][j]= -1;
						}
						else{
							A[l][j]= Double.MAX_VALUE;
							P[l][j]= -1;
						}
					}
				}
			}
			for(int i = 0; i < numNodes; i++)
			{
				for(int j = 0; j < numNodes; j++)
				{
					for(int k = 0; k < numNodes; k++)
					{
						if((A[i][j]+A[j][k]<A[i][k]))
						{
							A[i][k]= A[i][j]+A[j][k];
							P[i][k]= j;
								
//							System.out.print(i + " > " + k + " ==> " + i + " > " + j + " > " + k + " = " + j + "\n");
						}
					}
				}
				
			}
			return A;
		}
		
		/**
		 * Excentricidad de un nodo, el mayor de los costes minimos que tienen a ese nodo como destino desde cualquier otro
		 * @param nodo, nodo del que se quiere calcular la excentricidad
		 * @return result, peso del coste mayor dentro de los costes minimo
		 */
		public double excentricidad(T nodo){
			double [][] exc = floydExcentricidad();
			int a = getNode(nodo);
			double result = 0.0;
			
			for(int i = 0; i<numNodes; i++){
				if(exc[i][a]>result){
					result = exc[i][a];
				}
			}
//			System.out.println("Excentricidad del nodo " + a + " = " + result);
			return result;
		}
		
		/**
		 * M�todo para calcular el centro de un grafo, calcula el minimo de la excentricidad de cada nodo
		 * @return value, posicion que ocupa el nodo central dentro del grafo
		 */
		public int centro(){
			double [] aux = new double [numNodes];
			for(int i = 0; i < numNodes; i++){
				aux[i] = excentricidad(nodes[i]);
			}
			
			double min = Double.MAX_VALUE;
			int value = 0;
			for(int i =0; i < numNodes; i++){
				if(aux[i]<min){
					min = aux[i];
					value = i;
				}
			}
//			System.out.print("Centro en el nodo " + value + " con peso " + min);
			return value;
		}
 }


