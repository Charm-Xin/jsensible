package dev.ocpd.jsensible.internal.nullability

import com.tngtech.archunit.base.DescribedPredicate
import com.tngtech.archunit.core.domain.JavaAnnotation
import com.tngtech.archunit.core.domain.JavaClass
import com.tngtech.archunit.core.domain.JavaClass.Predicates.simpleName
import com.tngtech.archunit.core.domain.properties.HasType.Predicates.rawType
import dev.ocpd.jsensible.internal.JavaClassPredicates.anyOf

/**
 * Predicates for nullability annotations.
 */
internal object NullabilityAnnotations {

    internal fun nonNullAnnotations(): DescribedPredicate<JavaAnnotation<*>> = rawType(
        anyOf(
            "org.jetbrains.annotations.NotNull",
            "org.springframework.lang.NonNull",
            "jakarta.annotation.Nonnull",
            "javax.annotation.Nonnull"
        )
    ).forSubtype()

    internal fun nullableAnnotations(): DescribedPredicate<JavaClass> =
        simpleName("Nullable")

    internal fun springNullableAnnotation(): DescribedPredicate<JavaClass> =
        anyOf("org.springframework.lang.Nullable")
}
