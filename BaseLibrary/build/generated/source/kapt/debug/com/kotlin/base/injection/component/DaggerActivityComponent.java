// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.kotlin.base.injection.component;

import android.app.Activity;
import android.content.Context;
import com.kotlin.base.injection.module.ActivityModule;
import com.kotlin.base.injection.module.ActivityModule_ProvideActivityFactory;
import com.kotlin.base.injection.module.LifecycleProviderModule;
import com.kotlin.base.injection.module.LifecycleProviderModule_ProvideLifecycleProviderFactory;
import com.trello.rxlifecycle.LifecycleProvider;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerActivityComponent implements ActivityComponent {
  private Provider<Activity> provideActivityProvider;

  private Provider<Context> contextProvider;

  private Provider<LifecycleProvider<?>> provideLifecycleProvider;

  private DaggerActivityComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideActivityProvider =
        DoubleCheck.provider(ActivityModule_ProvideActivityFactory.create(builder.activityModule));

    this.contextProvider =
        new com_kotlin_base_injection_component_AppComponent_context(builder.appComponent);

    this.provideLifecycleProvider =
        LifecycleProviderModule_ProvideLifecycleProviderFactory.create(
            builder.lifecycleProviderModule);
  }

  @Override
  public Activity activity() {
    return provideActivityProvider.get();
  }

  @Override
  public Context context() {
    return contextProvider.get();
  }

  @Override
  public LifecycleProvider<?> lifecycleProvider() {
    return provideLifecycleProvider.get();
  }

  public static final class Builder {
    private ActivityModule activityModule;

    private LifecycleProviderModule lifecycleProviderModule;

    private AppComponent appComponent;

    private Builder() {}

    public ActivityComponent build() {
      if (activityModule == null) {
        throw new IllegalStateException(ActivityModule.class.getCanonicalName() + " must be set");
      }
      if (lifecycleProviderModule == null) {
        throw new IllegalStateException(
            LifecycleProviderModule.class.getCanonicalName() + " must be set");
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerActivityComponent(this);
    }

    public Builder activityModule(ActivityModule activityModule) {
      this.activityModule = Preconditions.checkNotNull(activityModule);
      return this;
    }

    public Builder lifecycleProviderModule(LifecycleProviderModule lifecycleProviderModule) {
      this.lifecycleProviderModule = Preconditions.checkNotNull(lifecycleProviderModule);
      return this;
    }

    public Builder appComponent(AppComponent appComponent) {
      this.appComponent = Preconditions.checkNotNull(appComponent);
      return this;
    }
  }

  private static class com_kotlin_base_injection_component_AppComponent_context
      implements Provider<Context> {
    private final AppComponent appComponent;

    com_kotlin_base_injection_component_AppComponent_context(AppComponent appComponent) {
      this.appComponent = appComponent;
    }

    @Override
    public Context get() {
      return Preconditions.checkNotNull(
          appComponent.context(), "Cannot return null from a non-@Nullable component method");
    }
  }
}