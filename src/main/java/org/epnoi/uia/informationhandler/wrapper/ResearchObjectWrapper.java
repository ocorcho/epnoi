package org.epnoi.uia.informationhandler.wrapper;

import org.epnoi.model.Content;
import org.epnoi.model.Context;
import org.epnoi.model.Resource;
import org.epnoi.uia.core.Core;
import org.epnoi.uia.informationstore.InformationStore;
import org.epnoi.uia.informationstore.InformationStoreHelper;
import org.epnoi.uia.informationstore.Selector;
import org.epnoi.uia.informationstore.SelectorHelper;
import org.epnoi.uia.informationstore.dao.rdf.RDFHelper;

public class ResearchObjectWrapper implements Wrapper {
	Core core;

	// -------------------------------------------------------------------------------------------------------------

	public ResearchObjectWrapper(Core core) {
		this.core = core;
	}

	// -------------------------------------------------------------------------------------------------------------
	public void put(Resource resource, Context context) {

		InformationStore informationStore = this.core
				.getInformationStoresByType(
						InformationStoreHelper.RDF_INFORMATION_STORE).get(0);
		// System.out.println("--------------------------------------------->  "+informationStore);
		informationStore.put(resource, context);
		informationStore = this.core.getInformationStoresByType(
				InformationStoreHelper.SOLR_INFORMATION_STORE).get(0);

		informationStore.put(resource, context);

	}

	// ------------------------------------------------------------------------------------

	// -------------------------------------------------------------------------------------------------------------

	public Resource get(String URI) {
		InformationStore informationStore = this.core
				.getInformationStoresByType(
						InformationStoreHelper.RDF_INFORMATION_STORE).get(0);

		Selector selector = new Selector();
		selector.setProperty(SelectorHelper.TYPE,
				RDFHelper.RESEARCH_OBJECT_CLASS);
		selector.setProperty(SelectorHelper.URI, URI);
		return informationStore.get(selector);
	}

	// -------------------------------------------------------------------------------------

	public void remove(String URI) {

		InformationStore informationStore = this.core
				.getInformationStoresByType(
						InformationStoreHelper.RDF_INFORMATION_STORE).get(0);

		Selector selector = new Selector();
		selector.setProperty(SelectorHelper.TYPE,
				RDFHelper.RESEARCH_OBJECT_CLASS);
		selector.setProperty(SelectorHelper.URI, URI);
		informationStore.remove(selector);

		informationStore = this.core.getInformationStoresByType(
				InformationStoreHelper.SOLR_INFORMATION_STORE).get(0);
		informationStore.remove(selector);

	}

	// -------------------------------------------------------------------------------------

	@Override
	public void update(Resource resource) {
		this.remove(resource.getURI());
		this.put(resource, Context.getEmptyContext());

	}
	
	// -------------------------------------------------------------------------------------

		@Override
		public boolean exists(String URI) {
			// TODO Auto-generated method stub
			return false;
		}

		// -------------------------------------------------------------------------------------
		
		@Override
		public Content<String> getContent(Selector selector) {
			// TODO Auto-generated method stub
			return null;
		}

		// -------------------------------------------------------------------------------------
		
		@Override
		public void setContent(Selector selector, Content<String> content) {
			// TODO Auto-generated method stub
			
		}

		// -------------------------------------------------------------------------------------
		
		@Override
		public Content<String> getAnnotatedContent(Selector selector) {
			// TODO Auto-generated method stub
			return null;
		}
		
		// -------------------------------------------------------------------------------------

		@Override
		public void setAnnotatedContent(Selector selector,
				Content<String> annotatedContent) {
			// TODO Auto-generated method stub
			
		}

	// -------------------------------------------------------------------------------------

		
		
}
