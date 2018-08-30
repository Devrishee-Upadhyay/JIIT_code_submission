
package javaapplication1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class JavaApplication1 
{
    static int Nodenum;
   class Node
   {
       Date timestamp;
       int data;
       int nodeNumber;
       String NodeID;
       String refNodeID;
       String childRefNodeID;
       String genesisRefNode;
       String Hashvalue;
       ArrayList<Node> link=new ArrayList();
       
       public Node(Date timestamp,int data,int node,String nodeID, String refNodeID, String childRefID,String genesisRefNode)
       {
           this.timestamp=timestamp;
           this.NodeID=nodeID;
           this.data=data;
           this.nodeNumber=node;
           this.refNodeID=refNodeID;
           this.childRefNodeID=childRefID;
           this.genesisRefNode=genesisRefNode;
           String h=data+node+nodeID+refNodeID+childRefID+genesisRefNode+timestamp;
           this.Hashvalue=this.getHashValue(h);
           
       }
       
       public String getHashvalue(String s)
       {
           int ans=s.hashCode();
           String k=ans+"";
           return k;
       }
       
       public void createNode(Node A,Date timestamp,int data,String nodeID, String refNodeID, String childRefID,String genesisRefNode)
       {
           Nodenum++;
           if(A==null)
           {
               genesis=new Node(timestamp,data,Nodenum,nodeID,refNodeID,childRefID,genesisRefNode);
           }    
           Node temp=new Node(timestamp,data,node,nodeID,refNodeID,childRefID,genesisRefNode);
           String pid=refNodeID;
           Node parent=findparent(pid);
           int i=0;
           int n=this.link.size();
           int sum=0;
           while(i<n)
           {
               Node n1=this.link.get(i);
               sum=sum+n1.data;
               i++;
           }
           if(this.data>(parent.data-sum))
           {
               parent.link.add(i,temp);
           }
       }
      
   }
   Node genesis; 
    public static void main(String[] args) 
    {
       JavaApplication1 j=new JavaApplication1();
       SimpleDateFormat s=new SimpleDateFormat();
       j.createNode(s,30,"1");
       j.createNode(s,17,"2");
       j.createNode(s,12,"3");
       j.createNode(s,3,"4");
    }
    
}
