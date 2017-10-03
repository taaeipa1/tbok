<!--  http://www.servletsuite.com/servlets/treetag.htm -->

<%@ taglib uri="taglib.tld" prefix="tree" %>




<tree:createTree defaultConnectors="false" treePicture="pic/tree.gif" nodePicture="pic/leaf.gif" openPicture="pic/open.gif" verticalConnector="pic/vertical.gif" middleConnector="pic/middle.gif" dhtml="true"> 
  <tree:addNode code="<b>node 1</b>"> 
    <tree:addNode code="node 1.1"/> 
    <tree:addNode picture="open.gif" code="node 1.2"> 
      <tree:addNode code="node 1.2.1"/> 
      <tree:addNode code="node 1.2.2"/> 
    </tree:addNode> 
    <tree:addNode code="node 1.3"/> 
  </tree:addNode> 
  <tree:addNode code="node 2"/> 
</tree:createTree>


<% 
com.cj.tree.TreeBean root=new com.cj.tree.TreeBean(); 
root.setCode("Root"); 

com.cj.tree.TreeBean node1=new com.cj.tree.TreeBean(); 
node1.setCode("Node 1"); 

com.cj.tree.TreeBean node2=new com.cj.tree.TreeBean(); 
node2.setCode("Node 2"); 

com.cj.tree.TreeBean node11=new com.cj.tree.TreeBean(); 
node11.setCode("Node 1.1"); 

root.addChild(node1); 
root.addChild(node2); 

node1.addChild(node11); 

%> 

<tree:createTree defaultConnectors="false" verticalConnector="pic/vertical.gif" middleConnector="pic/middle.gif" 
modelBean="<%=root%>"> 
</tree:createTree>