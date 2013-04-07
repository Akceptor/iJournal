package org.akceptor.ijournal.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subject_id")
	private int subjectID;

	@Column(name = "subject_name")
	private String subjectName;
	
	 @OneToMany
	 public Set<Lesson> lessons;
	
	public int getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	
//		@ManyToOne
//	    @JoinColumn(name="subject_id", referencedColumnName = "subject_id", insertable = false, updatable = false)
//	    private Lesson lessons;

	

}