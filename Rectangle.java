package stateandbehavior;
public class Rectangle {
	public int minX;
	public int minY;
	public int maxX;
	public int maxY;
	
	public int getMinX() {
		return minX;
	}
	public int getMinY() {
		return minY;
	}
	public int getMaxX() {
		return maxX;
	}
	public int getMaxY() {
		return maxY;
	}
	public int getWidth() {
		if(isEmpty()) {
			return 0;
		}
		return maxX-minX+1;
	}
	public int getHeight() {
		if(isEmpty()) {
			return 0;
		}
		return maxY-minY+1;
	}
	public boolean isEmpty() {
		return (maxY==0 && maxX==0 && minX==0 && minY==0);
	}

	public boolean contains(int x, int y) {
		return (x>=minX && x<=maxX && y<=maxY && y>=minY && !isEmpty());
	}
	public boolean contains(Rectangle rect) {
		return (rect.minX>=minX && rect.maxX>=maxX && rect.maxY<=maxY && rect.minY>=minY && (!isEmpty()||!rect.isEmpty()));
	}
	public boolean add(int x, int y) {
		if(contains(x,y)) {
			return false;
		}
		if(isEmpty()) {
			minX=maxX=x;
			minY=maxY=y;
			return true;
		}
		if(x>maxX) {
			maxX=x;
		}
		else if(x<minX) {
			minX=x;
		}
		if(y>maxY) {
			maxY=y;
		}
		else if(y<minY) {
			minY=y;
		}
		return true;
	}
	public boolean add(Rectangle rect) {
		if(contains(rect)) {
			return false;
		}
		if(rect.isEmpty()) {
			return false;
		}
		if(isEmpty()) {
			minX=rect.minX;
			minY=rect.minY;
			maxX=rect.maxX;
			maxY=rect.maxY;
			return true;
		}
		if(rect.maxX>maxX) {
			maxX=rect.maxX;
		}
		if(rect.minX<minX) {
			minX=rect.minX;
		}
		if(rect.maxY>maxY) {
			maxY=rect.maxY;
		}
		if(rect.minY<minY) {
			minY=rect.minY;
		}
		return true;
		
	}
	public Rectangle union(Rectangle rect) {
		Rectangle uni = new Rectangle();
		uni.maxX = Math.max(rect.maxX, maxX);
		uni.minX = Math.min(rect.minX, minX);
		uni.maxY = Math.max(rect.maxY, maxY);
		uni.minY = Math.min(rect.minY, minY);
		return uni;
	}
	public String toString() {
		return "H: "+getHeight()+", W: "+getWidth();
	}
	// gjør det raskere å printe i main()
	private static void p(Rectangle rect) {
		System.out.println(rect.toString());
	}
	public static void main(String[] args) {
		Rectangle r = new Rectangle();
		p(r);
		r.add(2,2);
		p(r);
		r.add(5,6);
		p(r);
		System.out.println(r.contains(4,4));
		Rectangle r2 = new Rectangle();
		r2.add(1,1);
		r2.add(2,2);
		p(r2);
		r.add(r2);
		p(r);
		
		
	}
}