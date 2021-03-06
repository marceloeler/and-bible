package net.bible.service.db.bookmark;


import net.bible.android.control.bookmark.BookmarkStyle;

import org.apache.commons.lang.StringUtils;

/**
 * @author Martin Denham [mjdenham at gmail dot com]
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's author.
 */
public class LabelDto implements Comparable<LabelDto> {
	private Long id;
	private String name;
	private BookmarkStyle bookmarkStyle;

	@Override
	public String toString() {
		return getName();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LabelDto other = (LabelDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public BookmarkStyle getBookmarkStyle() {
		return bookmarkStyle;
	}

	public void setBookmarkStyle(BookmarkStyle bookmarkStyle) {
		this.bookmarkStyle = bookmarkStyle;
	}

	public String getBookmarkStyleAsString() {
		if (bookmarkStyle==null) {
			return null;
		} else {
			return bookmarkStyle.name();
		}
	}

	public void setBookmarkStyleFromString(String bookmarkStyle) {
		if (StringUtils.isEmpty(bookmarkStyle)) {
			this.bookmarkStyle = null;
		} else {
			this.bookmarkStyle = BookmarkStyle.valueOf(bookmarkStyle);
		}
	}

	@Override
	public int compareTo(LabelDto another) {
		assert another!=null;
		return name.compareToIgnoreCase(another.name);
	}
}
