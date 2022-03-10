import java.util.List;
import com.eomcs.mylist.domain.Board;

public interface BoardDao {

  int countAll() throws Exception;

  List<Board> findAll() throws Exception;
  
  int insert(Board board) throws Exception;

  Board findByNo(int no) throws Exception;

  int update(int no, Board board) throws Exception;

  int delete(int no) throws Exception;

  int increaseViewCount(int no) throws Exception;
}