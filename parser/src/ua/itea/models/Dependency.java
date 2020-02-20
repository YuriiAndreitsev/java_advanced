package ua.itea.models;

public class Dependency {
	private String groupId;
	private String artifactId;
	private String version;
	private String scope;

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public Dependency(String groupId, String artifactId, String version) {
		super();
		this.groupId = groupId;
		this.artifactId = artifactId;
		this.version = version;
	}

	public Dependency() {
	}

	@Override
	public String toString() {
		return "Dependency [groupId=" + groupId + ", artifactId=" + artifactId + ", version=" + version + ", scope="
				+ scope + "]";
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

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
