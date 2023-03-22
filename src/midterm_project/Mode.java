package midterm_project;

public enum Mode {
	SelectMode("select", "select btn clicked"),
	AssociationlineMode("association_line", "association line btn clicked"),
	GeneralizationLineMode("generalization_line", "generalization line btn clicked"),
	CompositionLineMode("composition_line", "composition_line btn clicked"),
	ClassMode("class", "calss case btn clicked"),
	UseCaseMode("use_case", "use case btn clicked"); 
	
	private String name;
	private String btnString;
	
	Mode(String name, String btnString) {
		this.name = name;
		this.btnString = btnString;
	} 
	
	public String getName() {
		return name;
	}
	
	public String getImgPath() {
		return "./src/images/" + name + "_icon.png";
	}
	
	public String getBtnString() {
		return btnString;
	}
	// getIconPath()
}
