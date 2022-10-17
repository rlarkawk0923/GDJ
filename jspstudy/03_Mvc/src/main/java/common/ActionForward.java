package common;

public class ActionForward {
	
	private String view;
	private boolean isRedirect; // 이동방식 (true면 리다이렉트 false면 포워드)

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
}
