package com.example.calcetinder.datos;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.calcetinder.modelo.Calcetin;
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
public final class CalcetinDAO_Impl implements CalcetinDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Calcetin> __insertionAdapterOfCalcetin;

  private final EntityDeletionOrUpdateAdapter<Calcetin> __deletionAdapterOfCalcetin;

  private final EntityDeletionOrUpdateAdapter<Calcetin> __updateAdapterOfCalcetin;

  public CalcetinDAO_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCalcetin = new EntityInsertionAdapter<Calcetin>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `calcetines` (`id`,`usuarioId`,`nombre`,`descripcion`,`color`,`material`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Calcetin entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getUsuarioId());
        if (entity.getNombre() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getNombre());
        }
        if (entity.getDescripcion() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDescripcion());
        }
        if (entity.getColor() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getColor());
        }
        if (entity.getMaterial() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getMaterial());
        }
      }
    };
    this.__deletionAdapterOfCalcetin = new EntityDeletionOrUpdateAdapter<Calcetin>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `calcetines` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Calcetin entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfCalcetin = new EntityDeletionOrUpdateAdapter<Calcetin>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `calcetines` SET `id` = ?,`usuarioId` = ?,`nombre` = ?,`descripcion` = ?,`color` = ?,`material` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Calcetin entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getUsuarioId());
        if (entity.getNombre() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getNombre());
        }
        if (entity.getDescripcion() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDescripcion());
        }
        if (entity.getColor() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getColor());
        }
        if (entity.getMaterial() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getMaterial());
        }
        statement.bindLong(7, entity.getId());
      }
    };
  }

  @Override
  public Object insertar(final Calcetin calcetin, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCalcetin.insert(calcetin);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object eliminar(final Calcetin calcetin, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfCalcetin.handle(calcetin);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object actualizar(final Calcetin calcetin, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfCalcetin.handle(calcetin);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<Calcetin> obtener(final int id) {
    final String _sql = "SELECT * FROM calcetines WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"calcetines"}, new Callable<Calcetin>() {
      @Override
      @Nullable
      public Calcetin call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUsuarioId = CursorUtil.getColumnIndexOrThrow(_cursor, "usuarioId");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final int _cursorIndexOfMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "material");
          final Calcetin _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpUsuarioId;
            _tmpUsuarioId = _cursor.getInt(_cursorIndexOfUsuarioId);
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final String _tmpDescripcion;
            if (_cursor.isNull(_cursorIndexOfDescripcion)) {
              _tmpDescripcion = null;
            } else {
              _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
            }
            final String _tmpColor;
            if (_cursor.isNull(_cursorIndexOfColor)) {
              _tmpColor = null;
            } else {
              _tmpColor = _cursor.getString(_cursorIndexOfColor);
            }
            final String _tmpMaterial;
            if (_cursor.isNull(_cursorIndexOfMaterial)) {
              _tmpMaterial = null;
            } else {
              _tmpMaterial = _cursor.getString(_cursorIndexOfMaterial);
            }
            _result = new Calcetin(_tmpId,_tmpUsuarioId,_tmpNombre,_tmpDescripcion,_tmpColor,_tmpMaterial);
          } else {
            _result = null;
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
  public Flow<List<Calcetin>> obtenerPorUsuario(final int usuarioId) {
    final String _sql = "SELECT * FROM calcetines WHERE usuarioId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, usuarioId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"calcetines"}, new Callable<List<Calcetin>>() {
      @Override
      @NonNull
      public List<Calcetin> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUsuarioId = CursorUtil.getColumnIndexOrThrow(_cursor, "usuarioId");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final int _cursorIndexOfMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "material");
          final List<Calcetin> _result = new ArrayList<Calcetin>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Calcetin _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpUsuarioId;
            _tmpUsuarioId = _cursor.getInt(_cursorIndexOfUsuarioId);
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final String _tmpDescripcion;
            if (_cursor.isNull(_cursorIndexOfDescripcion)) {
              _tmpDescripcion = null;
            } else {
              _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
            }
            final String _tmpColor;
            if (_cursor.isNull(_cursorIndexOfColor)) {
              _tmpColor = null;
            } else {
              _tmpColor = _cursor.getString(_cursorIndexOfColor);
            }
            final String _tmpMaterial;
            if (_cursor.isNull(_cursorIndexOfMaterial)) {
              _tmpMaterial = null;
            } else {
              _tmpMaterial = _cursor.getString(_cursorIndexOfMaterial);
            }
            _item = new Calcetin(_tmpId,_tmpUsuarioId,_tmpNombre,_tmpDescripcion,_tmpColor,_tmpMaterial);
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
  public Flow<List<Calcetin>> obtenerTodos() {
    final String _sql = "SELECT * FROM calcetines";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"calcetines"}, new Callable<List<Calcetin>>() {
      @Override
      @NonNull
      public List<Calcetin> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUsuarioId = CursorUtil.getColumnIndexOrThrow(_cursor, "usuarioId");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
          final int _cursorIndexOfColor = CursorUtil.getColumnIndexOrThrow(_cursor, "color");
          final int _cursorIndexOfMaterial = CursorUtil.getColumnIndexOrThrow(_cursor, "material");
          final List<Calcetin> _result = new ArrayList<Calcetin>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Calcetin _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpUsuarioId;
            _tmpUsuarioId = _cursor.getInt(_cursorIndexOfUsuarioId);
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final String _tmpDescripcion;
            if (_cursor.isNull(_cursorIndexOfDescripcion)) {
              _tmpDescripcion = null;
            } else {
              _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
            }
            final String _tmpColor;
            if (_cursor.isNull(_cursorIndexOfColor)) {
              _tmpColor = null;
            } else {
              _tmpColor = _cursor.getString(_cursorIndexOfColor);
            }
            final String _tmpMaterial;
            if (_cursor.isNull(_cursorIndexOfMaterial)) {
              _tmpMaterial = null;
            } else {
              _tmpMaterial = _cursor.getString(_cursorIndexOfMaterial);
            }
            _item = new Calcetin(_tmpId,_tmpUsuarioId,_tmpNombre,_tmpDescripcion,_tmpColor,_tmpMaterial);
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
