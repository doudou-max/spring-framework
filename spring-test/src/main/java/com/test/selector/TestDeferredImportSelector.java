package com.test.selector;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: doudou
 * @since: 2022-11-15
 * deferred:延期的 -> 表明是延期加载的
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

		/** 调用 ImportSelector 的 selectImports() 方法，将返回的 String[] 添加到 instanceImports */
		@Override
		public void process(@NotNull AnnotationMetadata metadata, DeferredImportSelector selector) {
			for (String importClassName : selector.selectImports(metadata)) {
				this.instanceImports.add(new Entry(metadata, importClassName));
			}
		}

		/** 返回 process() 收集到的 String[] */
		@NotNull
		@Override
		public Iterable<Entry> selectImports() {
			return instanceImports;
		}
	}

}
