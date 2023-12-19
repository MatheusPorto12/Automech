import '../../App.css';
import { SearchBar } from '../search/search';
import { TableResult } from '../tableResult/tableResult';
import '../../css/search.css'
import '../../css/style.css'

export function SearchScreen() {
  return (
    
    <div>
    <SearchBar></SearchBar>
    <TableResult></TableResult></div>
  );
}