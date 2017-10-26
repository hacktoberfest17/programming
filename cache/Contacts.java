import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/*
 * Demo create cache for store contacts
 * 
 * With method: add to cache and query the totals count according the input name
 * 
 * 
 * 
 */

public class Contacts {
	
	public enum Operation {
		ADD("add"),
		FIND_PARTIAL("find");
		
		private final String value;

	    private Operation(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}
	
	// key uuid's string
	private Map<String, Member> _memberCacheMap;
		
	public Contacts() {
		_memberCacheMap = new HashMap<String, Member>();
	}
	
	public void addToCache(String name) {
		Member m = new Member(name);
		_memberCacheMap.put(m.getUuid().toString(), m);
	}
	
	public int findMemberCount(String partialName) {
		int count = 0;
		
		count = (int) _memberCacheMap.values()
				.stream()
				.filter(v -> v.getName().contains(partialName))
				.count();
		
		return count;
	}
	
	
	class Member {
		private String name;
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public UUID getUuid() {
			return uuid;
		}

		public void setUuid(UUID uuid) {
			this.uuid = uuid;
		}

		private UUID uuid;
		
		public Member() {
			this.uuid = UUID.randomUUID();
		}
		
		public Member(String name) {
			this.name = name;
			this.uuid = UUID.randomUUID();
		}
	}
}
