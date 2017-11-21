package teamreborn.techreborn.base.util;

import teamreborn.techreborn.base.module.TRModule;

public interface TechRebornItem {
	public String getItemName();

	default public int maxMetadata() {
		return 0;
	}
}
