package org.springframework.batch.core.configuration.xml;

import org.springframework.batch.core.listener.AbstractListenerFactoryBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * Parse &lt;job-listener/&gt; elements in the batch namespace.
 * 
 * @author Dan Garrette
 * @since 2.0
 */
public class TopLevelJobListenerParser extends AbstractSingleBeanDefinitionParser {

	private JobExecutionListenerParser jobListenerParser = new JobExecutionListenerParser();

	@Override
	protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
		jobListenerParser.doParse(element, parserContext, builder);
	}

	@Override
	protected Class<? extends AbstractListenerFactoryBean> getBeanClass(Element element) {
		return jobListenerParser.getBeanClass();
	}

}
