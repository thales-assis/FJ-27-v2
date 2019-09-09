package br.com.alura.forum.controller.dto.input;


import br.com.alura.forum.controller.exception.CourseNotFoundException;
import br.com.alura.forum.model.Course;
import br.com.alura.forum.model.User;
import br.com.alura.forum.model.topic.domain.Topic;
import br.com.alura.forum.repository.CourseRepository;

public class NewTopicInputDto {

	private String shortDescription;
	private String content;
	private String courseName;

	public NewTopicInputDto(String shortDescription, String content, String courseName) {
		super();
		this.shortDescription = shortDescription;
		this.content = content;
		this.courseName = courseName;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Topic build(User owner, CourseRepository courseRepository) {
		Course course = courseRepository.findByName(this.courseName).orElseThrow(() -> new CourseNotFoundException("Could not find course with name: " + courseName));
		return new Topic(this.shortDescription, this.content, owner, course);
	}

}