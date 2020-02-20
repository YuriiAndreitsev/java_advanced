package ua.itea.parser;

import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ua.itea.models.Dependency;
import ua.itea.models.Project;

public class MySAXParser extends DefaultHandler {
	Project project = null;
	Dependency dependency = null;
	private StringBuilder data = null;
	private boolean groupId = false;
	private boolean artifactId = false;
	private boolean version = false;
	private boolean packaging = false;
	private boolean name = false;
	private boolean sourceEncoding = false;
	private boolean source = false;
	private boolean target = false;
	private boolean dep = false;
	private boolean scope = false;
	Map<String, String> props = null;

	@Override
	public void startDocument() throws SAXException {
		System.out.println("started parsing");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("project")) {
			project = new Project();
			StringBuilder atts = new StringBuilder();
			for (int i = 0; i < attributes.getLength(); i++) {
				atts.append(attributes.getLocalName(i) + " : " + attributes.getValue(i) + " ; ");
			}
			project.setProjectAttributes(atts.toString());

		} else if (qName.equals("groupId")) {
			groupId = true;
		} else if (qName.equals("artifactId")) {
			artifactId = true;
		} else if (qName.equals("version")) {
			version = true;
		} else if (qName.equals("scope")) {
			scope = true;
		} else if (qName.equals("packaging")) {
			packaging = true;
		} else if (qName.equals("name")) {
			name = true;
		} else if (qName.equals("project.build.sourceEncoding")) {
			sourceEncoding = true;
		} else if (qName.equals("maven.compiler.source")) {
			source = true;
		} else if (qName.equals("maven.compiler.target")) {
			target = true;
		} else if (qName.equals("dependency")) {
			dep = true;
			dependency = new Dependency();
			if (qName.equals("groupId")) {
				groupId = true;
				data = new StringBuilder();
			} else if (qName.equals("artifactId")) {
				artifactId = true;
				data = new StringBuilder();
			} else if (qName.equals("version")) {
				version = true;
				data = new StringBuilder();
			} else if (qName.equals("scope")) {
				scope = true;
				data = new StringBuilder();
			}
		} 

		data = new StringBuilder();
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		if (dep) {
			data.append(new String(ch, start, length));

			if (groupId) {
				dependency.setGroupId(data.toString());
			} else if (artifactId) {
				dependency.setArtifactId(data.toString());
			} else if (version) {
				dependency.setVersion(data.toString());
			} else if (scope) {
				scope = false;
				dependency.setScope(data.toString());
			}
		} else {
			data.append(new String(ch, start, length));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (groupId) {
			groupId = false;
			project.setGroupId(data.toString());
		} else if (artifactId) {
			artifactId = false;
			project.setArtifactId(data.toString());
		} else if (version) {
			version = false;
			project.setVersion(data.toString());
		} else if (packaging) {
			packaging = false;
			project.setPackaging(data.toString());
		} else if (name) {
			name = false;
			project.setName(data.toString());
		} else if (sourceEncoding) {
			sourceEncoding = false;
			props = project.getProperties();
			props.put("project.build.sourceEncoding", data.toString());
		} else if (source) {
			source = false;
			props.put("maven.compiler.source", data.toString());
		} else if (target) {
			target = false;
			props.put("maven.compiler.target", data.toString());
			project.setProperties(props);
		} else if (dep) {
			dep = false;
			project.getDependencyList().add(dependency);
		}

//		if (qName.equals("project")) {
////			here we can add our entity to list if we want
//		}  
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println(project);
	}

}
