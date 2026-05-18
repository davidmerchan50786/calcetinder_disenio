package com.example.calcetinder.datos;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.calcetinder.modelo.Match;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class MatchDAO_Impl implements MatchDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Match> __insertionAdapterOfMatch;

  public MatchDAO_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMatch = new EntityInsertionAdapter<Match>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `matches` (`id`,`usuarioId`,`calcetinId`,`tipoMatch`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Match entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getUsuarioId());
        statement.bindLong(3, entity.getCalcetinId());
        if (entity.getTipoMatch() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getTipoMatch());
        }
      }
    };
  }

  @Override
  public Object insertar(final Match match, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMatch.insert(match);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Match>> obtenerMatches(final int usuarioId) {
    final String _sql = "SELECT * FROM matches WHERE usuarioId = ? AND tipoMatch = 'like'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, usuarioId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"matches"}, new Callable<List<Match>>() {
      @Override
      @NonNull
      public List<Match> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUsuarioId = CursorUtil.getColumnIndexOrThrow(_cursor, "usuarioId");
          final int _cursorIndexOfCalcetinId = CursorUtil.getColumnIndexOrThrow(_cursor, "calcetinId");
          final int _cursorIndexOfTipoMatch = CursorUtil.getColumnIndexOrThrow(_cursor, "tipoMatch");
          final List<Match> _result = new ArrayList<Match>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Match _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpUsuarioId;
            _tmpUsuarioId = _cursor.getInt(_cursorIndexOfUsuarioId);
            final int _tmpCalcetinId;
            _tmpCalcetinId = _cursor.getInt(_cursorIndexOfCalcetinId);
            final String _tmpTipoMatch;
            if (_cursor.isNull(_cursorIndexOfTipoMatch)) {
              _tmpTipoMatch = null;
            } else {
              _tmpTipoMatch = _cursor.getString(_cursorIndexOfTipoMatch);
            }
            _item = new Match(_tmpId,_tmpUsuarioId,_tmpCalcetinId,_tmpTipoMatch);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Match>> obtenerTodos() {
    final String _sql = "SELECT * FROM matches";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"matches"}, new Callable<List<Match>>() {
      @Override
      @NonNull
      public List<Match> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUsuarioId = CursorUtil.getColumnIndexOrThrow(_cursor, "usuarioId");
          final int _cursorIndexOfCalcetinId = CursorUtil.getColumnIndexOrThrow(_cursor, "calcetinId");
          final int _cursorIndexOfTipoMatch = CursorUtil.getColumnIndexOrThrow(_cursor, "tipoMatch");
          final List<Match> _result = new ArrayList<Match>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Match _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpUsuarioId;
            _tmpUsuarioId = _cursor.getInt(_cursorIndexOfUsuarioId);
            final int _tmpCalcetinId;
            _tmpCalcetinId = _cursor.getInt(_cursorIndexOfCalcetinId);
            final String _tmpTipoMatch;
            if (_cursor.isNull(_cursorIndexOfTipoMatch)) {
              _tmpTipoMatch = null;
            } else {
              _tmpTipoMatch = _cursor.getString(_cursorIndexOfTipoMatch);
            }
            _item = new Match(_tmpId,_tmpUsuarioId,_tmpCalcetinId,_tmpTipoMatch);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
