package org.akceptor.ijournal.dao;

import java.util.List;

import org.akceptor.ijournal.domain.Group;

public interface GroupDAO {
	public void addGroup(Group group);
	public void updateGroup(Group group);
	public void delete(Group group);
	public Group getGroupByName(String groupName);
	public List<Group> findGroups();
	public Group getGroupByID(int groupID);
}