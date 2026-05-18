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
import com.example.calcetinder.modelo.Usuario;
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
public final class UsuarioDAO_Impl implements UsuarioDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Usuario> __insertionAdapterOfUsuario;

  private final EntityDeletionOrUpdateAdapter<Usuario> __deletionAdapterOfUsuario;

  private final EntityDeletionOrUpdateAdapter<Usuario> __updateAdapterOfUsuario;

  public UsuarioDAO_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUsuario = new EntityInsertionAdapter<Usuario>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `usuarios` (`id`,`nombre`,`email`,`contrasena`,`ciudad`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Usuario entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNombre() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNombre());
        }
        if (entity.getEmail() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getEmail());
        }
        if (entity.getContrasena() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getContrasena());
        }
        if (entity.getCiudad() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCiudad());
        }
      }
    };
    this.__deletionAdapterOfUsuario = new EntityDeletionOrUpdateAdapter<Usuario>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `usuarios` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Usuario entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfUsuario = new EntityDeletionOrUpdateAdapter<Usuario>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `usuarios` SET `id` = ?,`nombre` = ?,`email` = ?,`contrasena` = ?,`ciudad` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Usuario entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNombre() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNombre());
        }
        if (entity.getEmail() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getEmail());
        }
        if (entity.getContrasena() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getContrasena());
        }
        if (entity.getCiudad() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCiudad());
        }
        statement.bindLong(6, entity.getId());
      }
    };
  }

  @Override
  public Object insertar(final Usuario usuario, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUsuario.insert(usuario);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object eliminar(final Usuario usuario, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfUsuario.handle(usuario);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object actualizar(final Usuario usuario, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfUsuario.handle(usuario);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<Usuario> obtener(final int id) {
    final String _sql = "SELECT * FROM usuarios WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"usuarios"}, new Callable<Usuario>() {
      @Override
      @Nullable
      public Usuario call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfContrasena = CursorUtil.getColumnIndexOrThrow(_cursor, "contrasena");
          final int _cursorIndexOfCiudad = CursorUtil.getColumnIndexOrThrow(_cursor, "ciudad");
          final Usuario _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpContrasena;
            if (_cursor.isNull(_cursorIndexOfContrasena)) {
              _tmpContrasena = null;
            } else {
              _tmpContrasena = _cursor.getString(_cursorIndexOfContrasena);
            }
            final String _tmpCiudad;
            if (_cursor.isNull(_cursorIndexOfCiudad)) {
              _tmpCiudad = null;
            } else {
              _tmpCiudad = _cursor.getString(_cursorIndexOfCiudad);
            }
            _result = new Usuario(_tmpId,_tmpNombre,_tmpEmail,_tmpContrasena,_tmpCiudad);
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
  public Flow<Usuario> login(final String email, final String contrasena) {
    final String _sql = "SELECT * FROM usuarios WHERE email = ? AND contrasena = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, email);
    }
    _argIndex = 2;
    if (contrasena == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, contrasena);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"usuarios"}, new Callable<Usuario>() {
      @Override
      @Nullable
      public Usuario call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfContrasena = CursorUtil.getColumnIndexOrThrow(_cursor, "contrasena");
          final int _cursorIndexOfCiudad = CursorUtil.getColumnIndexOrThrow(_cursor, "ciudad");
          final Usuario _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpContrasena;
            if (_cursor.isNull(_cursorIndexOfContrasena)) {
              _tmpContrasena = null;
            } else {
              _tmpContrasena = _cursor.getString(_cursorIndexOfContrasena);
            }
            final String _tmpCiudad;
            if (_cursor.isNull(_cursorIndexOfCiudad)) {
              _tmpCiudad = null;
            } else {
              _tmpCiudad = _cursor.getString(_cursorIndexOfCiudad);
            }
            _result = new Usuario(_tmpId,_tmpNombre,_tmpEmail,_tmpContrasena,_tmpCiudad);
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
  public Flow<List<Usuario>> obtenerTodos() {
    final String _sql = "SELECT * FROM usuarios";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"usuarios"}, new Callable<List<Usuario>>() {
      @Override
      @NonNull
      public List<Usuario> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfContrasena = CursorUtil.getColumnIndexOrThrow(_cursor, "contrasena");
          final int _cursorIndexOfCiudad = CursorUtil.getColumnIndexOrThrow(_cursor, "ciudad");
          final List<Usuario> _result = new ArrayList<Usuario>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Usuario _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpContrasena;
            if (_cursor.isNull(_cursorIndexOfContrasena)) {
              _tmpContrasena = null;
            } else {
              _tmpContrasena = _cursor.getString(_cursorIndexOfContrasena);
            }
            final String _tmpCiudad;
            if (_cursor.isNull(_cursorIndexOfCiudad)) {
              _tmpCiudad = null;
            } else {
              _tmpCiudad = _cursor.getString(_cursorIndexOfCiudad);
            }
            _item = new Usuario(_tmpId,_tmpNombre,_tmpEmail,_tmpContrasena,_tmpCiudad);
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
