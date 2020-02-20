package ua.itea.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project {

	private String projectAttributes;
	private String groupId;
	private String artifactId;
	private String version;
	private String packaging;
	private String name;
	Map<String, String> properties = new HashMap<String, String>();
	List<Dependency> dependencyList = new ArrayList<Dependency>();

	public List<Dependency> getDependencyList() {
		return dependencyList;
	}

	public void setDependencyList(List<Dependency> dependencyList) {
		this.dependencyList = dependencyList;
	}

	public Project(String groupId, String shopSpringMVC, String version, String packaging, String name,
			Map<String, String> properties) {
		super();
		this.groupId = groupId;
		this.artifactId = shopSpringMVC;
		this.version = version;
		this.packaging = packaging;
		this.name = name;
		this.properties = properties;
	}

	public Project() {
	}

	public String getProjectAttributes() {
		return projectAttributes;
	}

	public void setProjectAttributes(String projectAttributes) {
		this.projectAttributes = projectAttributes;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String shopSpringMVC) {
		this.artifactId = shopSpringMVC;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "Project [projectAttributes=" + projectAttributes + " groupId=" + groupId + ", artifactId=" + artifactId
				+ ", version=" + version + ", packaging=" + packaging + ", name=" + name + ", properties=" + properties
				+ ",\n dependencyList=" + dependencyList + "]";
	}

}
