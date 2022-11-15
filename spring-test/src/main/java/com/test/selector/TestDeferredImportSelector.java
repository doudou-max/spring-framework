package com.test.selector;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: doudou
 * @since: 2022-11-15
 */
public class TestDeferredImportSelector implements DeferredImportSelector {

	@NotNull
	@Override
	public String[] selectImports(@NotNull AnnotationMetadata importingClassMetadata) {
		return new String[]{TestBean.class.getName()};
	}

	@Override
	public Class<? extends Group> getImportGroup() {
		return TestDeferredImportSelectorGroup.class;
	}

	private static class TestDeferredImportSelectorGroup implements DeferredImportSelector.Group {

		private final List<Entry> instanceImports = new ArrayList<>();

		@Override
		public void process(@NotNull AnnotationMetadata metadata, DeferredImportSelector selector) {
			for (String importClassName : selector.selectImports(metadata)) {
				this.instanceImports.add(new Entry(metadata, importClassName));
			}
		}

		@NotNull
		@Override
		public Iterable<Entry> selectImports() {
			return instanceImports;
		}
	}

}
