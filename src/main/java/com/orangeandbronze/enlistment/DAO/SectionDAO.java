package com.orangeandbronze.enlistment.DAO;

import com.orangeandbronze.enlistment.Section;

public interface SectionDAO {

	Section findBySectionID (String sectionID);
	void save(Section section);
	
}
