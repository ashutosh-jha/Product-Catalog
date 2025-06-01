const Categoryfilter = ({categories, onSelect}) => {
    console.log("Categories in filter:", categories);
    console.log("Category sample:", categories[0]);
    return (
        <>
            <select id="categorySelect" className="form-select" onChange={(e) => onSelect(e.target.value)} >
                <option value="">All Categories</option>
                {categories.map(category => (
                    <option key={category.id} value={category.id}>{category.name}</option>
                ))}
            </select>
        </>
    )
}

export default Categoryfilter;