package UMLObject;

public class ConnectionLine {
	public ConnectionType type;
	public BasicObject obj_1, obj_2;
	public Port port_1, port_2;
	
	public ConnectionLine(ConnectionType type, BasicObject o1, Port p1, BasicObject o2, 
			Port p2) {
		this.type = type;
		// parent
		this.obj_1 = o1;
		// children
		this.obj_2 = o2;
		this.port_1 = p1;
		this.port_2 = p2;
	}
}
