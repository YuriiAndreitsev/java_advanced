package advanced.model;

import java.io.Serializable;

public class Pudge implements Serializable{
	
		private  String meatHook;
		private  String rot;
		private  String fleshHeap;
		private  String dismember;
		
		
		
		
		public Pudge() {
			super();
		}
		public Pudge(String meatHook, String rot, String fleshHeap, String dismember) {
			super();
			this.meatHook = meatHook;
			this.rot = rot;
			this.fleshHeap = fleshHeap;
			this.dismember = dismember;
		}

		public String getMeatHook() {
			return meatHook;
		}
		public void setMeatHook(String meatHook) {
			this.meatHook = meatHook;
		}
		public String getRot() {
			return rot;
		}
		public void setRot(String rot) {
			this.rot = rot;
		}
		public String getFleshHeap() {
			return fleshHeap;
		}
		public void setFleshHeap(String fleshHeap) {
			this.fleshHeap = fleshHeap;
		}
		public String getDismember() {
			return dismember;
		}
		public void setDismember(String dismember) {
			this.dismember = dismember;
		}
		@Override
		public String toString() {
			return "Pudge [meatHook=" + meatHook + ", rot=" + rot + ", fleshHeap=" + fleshHeap + ", dismember="
					+ dismember + "]";
		}
	
		
}
