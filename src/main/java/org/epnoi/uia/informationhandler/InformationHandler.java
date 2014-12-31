package org.epnoi.uia.informationhandler;

import org.epnoi.model.Content;
import org.epnoi.model.ContentSummary;
import org.epnoi.model.Context;
import org.epnoi.model.Resource;
import org.epnoi.uia.informationhandler.events.InformationAccessListener;
import org.epnoi.uia.informationstore.InformationStore;
import org.epnoi.uia.parameterization.ParametersModel;



public interface InformationHandler {

	public void put(Resource resource, Context context);

	public Resource get(String URI);

	public Resource get(String URI, String resourceType);

	public void remove(Resource resource);

	public void remove(String URI, String resourceType);

	public void init(ParametersModel parameters);

	public void addInformationStore(InformationStore informationStore);

	public void removeInformationStore(String URI);

	public void update(Resource resource);

	public void publish(String eventType, Resource source);
	
	public boolean contains(String URI, String resourceType);

	public void subscribe(InformationAccessListener listener,
			String subscriptionExpression);

	public ContentSummary getContentSummary(String URI);
	
	public Content<String> getContent(String URI);
	
	public Content<String> getAnnotatedContent(String URI);

	public void  setContent(String URI, Content<String> content);
	
	public void  setAnnotatedContent(String URI, Content<String> annotatedContent);

	
}