package cn.red.util;

public class Sort {
	private int sid;
	private String sname;
	private double sprice;
	private String sdesc;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public double getSprice() {
		return sprice;
	}
	public void setSprice(double sprice) {
		this.sprice = sprice;
	}
	public String getSdesc() {
		return sdesc;
	}
	public void setSdesc(String sdesc) {
		this.sdesc = sdesc;
	}
	@Override
	public String toString() {
		return "Sort [sid=" + sid + ", sname=" + sname + ", sprice=" + sprice + ", sdesc=" + sdesc + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sdesc == null) ? 0 : sdesc.hashCode());
		result = prime * result + sid;
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
		long temp;
		temp = Double.doubleToLongBits(sprice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sort other = (Sort) obj;
		if (sdesc == null) {
			if (other.sdesc != null)
				return false;
		} else if (!sdesc.equals(other.sdesc))
			return false;
		if (sid != other.sid)
			return false;
		if (sname == null) {
			if (other.sname != null)
				return false;
		} else if (!sname.equals(other.sname))
			return false;
		if (Double.doubleToLongBits(sprice) != Double.doubleToLongBits(other.sprice))
			return false;
		return true;
	}
	
}
