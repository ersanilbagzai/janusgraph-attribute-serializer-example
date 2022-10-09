graph = JanusGraphFactory.open('/root/training/config/janusgraph-cql-DT-Serializer.properties');
mgmt = graph.openManagement();
hello = mgmt.makePropertyKey('hello').dataType(StringBuffer.class).cardinality(Cardinality.SINGLE).make()
poi = mgmt.makePropertyKey('poi').dataType(ArrayList.class).cardinality(Cardinality.SINGLE).make()
mgmt.commit()
v = graph.addVertex()
v.property('hello', new StringBuffer('world'))
l = [] as ArrayList
l.add('rdu')
v.property('poi', l)
graph.tx().commit()
g = graph.traversal()
vx = g.V().next()
sb = vx.values('hello').next()
sb.getClass()
al = vx.values('poi').next()
al.getClass()
