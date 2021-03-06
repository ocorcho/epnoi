package org.epnoi.uia.learner;

import java.util.List;

import org.epnoi.model.Term;
import org.epnoi.uia.commons.Parameters;
import org.epnoi.uia.learner.relations.RelationsTable;
import org.epnoi.uia.learner.terms.AnnotatedWord;
import org.epnoi.uia.learner.terms.TermMetadata;
import org.epnoi.uia.learner.terms.TermVertice;
import org.epnoi.uia.learner.terms.TermsTable;

public class OntologyGraphFactory {

	static OntologyGraph build(Parameters ontologyLearningParamters, TermsTable termsTable, RelationsTable table){
		OntologyGraph initialOntology = new OntologyGraph();
		
		int initialNumberOfTerms = Integer.parseInt((String)ontologyLearningParamters.getParameterValue(OntologyLearningParameters.NUMBER_INITIAL_TERMS));

		List<Term> mostProblabeTerms= termsTable.getMostProbable(initialNumberOfTerms);
		for (Term term: mostProblabeTerms){
			TermVertice termVertice = new TermVertice(term);
			initialOntology.addVertex(termVertice);
		}
		
		return initialOntology;
	}
}
